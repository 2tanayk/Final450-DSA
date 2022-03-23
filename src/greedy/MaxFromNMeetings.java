package greedy;

import java.util.*;

public class MaxFromNMeetings {

    private static class Meeting {
        int start, end, index;

        public Meeting(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] startArr = new int[n];
        int[] endArr = new int[n];

        for (int i = 0; i < n; i++) {
            startArr[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            endArr[i] = sc.nextInt();
        }

        System.out.println(maxMeetings(startArr, endArr, n));
    }

    public static int maxMeetings(int[] startArr, int[] endArr, int n) {
        int meetings = 0;
        HashMap<Integer, Boolean> slotMap = new HashMap<>();
        ArrayList<Meeting> meetingList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            meetingList.add(new Meeting(startArr[i], endArr[i], i));
        }

        meetingList.sort((o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.index - o2.index;
            } else {
                return o1.end - o2.end;
            }
        });


        for (Meeting meeting : meetingList) {
            if (slotMap.containsKey(meeting.start) || slotMap.containsKey(meeting.end)) {
                continue;
            } else {
                boolean flag = false;
                for (int i = meeting.start + 1; i <= meeting.end - 1; i++) {
                    if (slotMap.containsKey(i)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    for (int i = meeting.start; i <= meeting.end; i++) {
                        slotMap.put(i, true);
                    }
                    meetings++;
                }
            }
        }
        return meetings;
    }
}
