package searchingandsorting;

import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();

        System.out.println(fourSum(arr, target));
    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = arr.length;
        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int reqd = (target - arr[i] - arr[j]);
                int l = j + 1, h = n - 1;

                while (l < h) {
                    if (arr[l] + arr[h] == reqd) {
                        ArrayList<Integer> a = new ArrayList<>();
                        a.add(arr[i]);
                        a.add(arr[j]);
                        a.add(arr[l]);
                        a.add(arr[h]);

                        ans.add(a);

                        while (l < h && arr[l] == a.get(2)) {
                            l++;
                        }

                        while (l < h && arr[h] == a.get(3)) {
                            h--;
                        }

                    } else if (arr[l] + arr[h] < reqd) {
                        l++;
                    } else {
                        h--;
                    }
                }

                while (j + 1 < n && arr[j + 1] == arr[j]) {
                    ++j;
                }
            }
            while (i + 1 < n && arr[i + 1] == arr[i]) {
                ++i;
            }
        }

        return ans;
    }
}
