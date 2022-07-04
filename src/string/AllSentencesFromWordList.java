package string;

import java.util.*;

public class AllSentencesFromWordList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        sc.nextLine();

        String[][] arr = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextLine();
            }
        }

        System.out.println(sentences(arr));
    }

    public static ArrayList<ArrayList<String>> sentences(String[][] arr) {
        int m = arr.length;
        int n = arr[0].length;

        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        allSentences(arr, m, n, 0, ans, "");

        return ans;
    }

    private static void allSentences(String[][] arr, int m, int n, int i, ArrayList<ArrayList<String>> ans, String s) {
        if (i == m) {
            ArrayList<String> temp = new ArrayList<>();
            temp.add(s);
            ans.add(temp);
            return;
        }

        for (int j = 0; j < n; j++) {
            if (s.length() != 0) {
                allSentences(arr, m, n, i + 1, ans, s + " " + arr[i][j]);
            } else {
                allSentences(arr, m, n, i + 1, ans, s + arr[i][j]);
            }
        }
    }
}
