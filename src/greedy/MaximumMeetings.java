package greedy;

import java.util.*;

public class MaximumMeetings {
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

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];

            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                end[i] = sc.nextInt();
            }

            System.out.println(maximumMeetings(start, end));
        }

    }

    public static List<Integer> maximumMeetings(int[] start, int[] end) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = start.length;
        Meeting[] meetings = new Meeting[n];

        for (int i = 0; i < n; i++) {
            meetings[i] = new Meeting(start[i], end[i], i + 1);
        }

        Arrays.sort(meetings, Comparator.comparingInt(e -> e.end));

        int max = meetings[0].end;
        ans.add(meetings[0].index);

        for (int i = 1; i < n; i++) {
            Meeting meeting = meetings[i];
            if (meeting.start > max) {
                ans.add(meeting.index);
                max = meeting.end;
            }
        }

        return ans;
    }
}
