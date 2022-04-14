package searchingandsorting;

import java.util.*;

public class FindValueEqualToIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findValuesEqualToIndices(arr, n));
    }

    private static ArrayList<Integer> findValuesEqualToIndices(int[] arr, int n) {
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] == (i + 1)) {
                answer.add(arr[i]);
            }
        }
        return answer;
    }
}
