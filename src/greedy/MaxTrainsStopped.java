package greedy;

import java.lang.reflect.Array;
import java.util.*;

public class MaxTrainsStopped {
    private static class TrainData {
        int no, arrival, departure, platform;

        public TrainData(int no, int arrival, int departure, int platform) {
            this.no = no;
            this.arrival = arrival;
            this.departure = departure;
            this.platform = platform;
        }

        @Override
        public String toString() {
            return "TrainData{" +
                    "no=" + no +
                    ", arrival=" + arrival +
                    ", departure=" + departure +
                    ", platform=" + platform +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        TrainData[] tArr = new TrainData[m];

        for (int i = 0; i < m; i++) {
            tArr[i] = new TrainData(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        System.out.println(maxTrainsStopped(tArr, m, n));
    }

    private static int maxTrainsStopped(TrainData[] arr, int m, int n) {
        int ct = 0;

        HashMap<Integer, TrainData> tMap = new HashMap<>();

        Arrays.sort(arr, Comparator.comparingInt(o -> o.departure));

        for (TrainData train : arr) {
            int platform = train.platform;

            if (!tMap.containsKey(platform)) {
                tMap.put(platform, train);
                ct++;
            } else {
                TrainData occupied = tMap.get(platform);

                if (occupied.departure <= train.arrival) {
                    tMap.put(platform, train);
                    ct++;
                }
            }
        }

        return ct;
    }
}
