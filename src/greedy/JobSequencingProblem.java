package greedy;

import java.util.*;

public class JobSequencingProblem {
    private static class Job {
        int id, deadline, profit;

        public Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Job[] jArr = new Job[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            int deadline = sc.nextInt();
            int profit = sc.nextInt();

            jArr[i] = new Job(id, deadline, profit);
        }

        System.out.println(Arrays.toString(printJobsDoneAndMaxProfit(jArr, n)));
    }

    private static int[] printJobsDoneAndMaxProfit(Job[] arr, int n) {
        Arrays.sort(arr, (o1, o2) -> {
            if (o1.profit != o2.profit) {
                return o2.profit - o1.profit;
            } else if (o1.deadline != o2.deadline) {
                return o2.deadline - o1.deadline;
            } else {
                return o1.id - o2.id;
            }
        });


        int maxD = arr[0].deadline;
        for (int i = 1; i < n; i++) {
            if (maxD < arr[i].deadline) {
                maxD = arr[i].deadline;
            }
        }

        int[] dArr = new int[maxD + 1];

        int profit = 0, jobs = 0;

        for (Job job : arr) {
            int deadline = job.deadline;
            while (deadline > 0) {
                if (dArr[deadline] == 0) {
                    profit += job.profit;
                    jobs++;
                    dArr[deadline] = 1;
                    break;
                }
                deadline--;
            }
        }

        int[] ans = new int[2];
        ans[0] = jobs;
        ans[1] = profit;

        return ans;
    }
}
