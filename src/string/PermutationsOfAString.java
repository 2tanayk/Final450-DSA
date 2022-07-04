package string;

import java.util.*;

public class PermutationsOfAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int len = s.length();

        System.out.println(findPermutations(s));
    }

    public static List<String> findPermutations(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<>();

        if (len == 1) {
            ans.add(s);
            return ans;
        }

        char[] stArr = s.toCharArray();
        HashSet<String> hs = new HashSet<>();

        permutations(0, stArr, len, ans, hs);

        Collections.sort(ans);

        return ans;
    }

    private static void permutations(int i, char[] stArr, int len, List<String> ans, HashSet<String> hs) {
        if (i == len - 1) {
            String s = "";

            for (char c : stArr) {
                s += c;
            }

            if (!hs.contains(s)) {
                ans.add(s);
                hs.add(s);
            }

            return;
        }

        int j = i;
        while (j < len) {
            swap(stArr, i, j);
            permutations(i + 1, stArr, len, ans, hs);
            swap(stArr, j, i);
            j++;
        }
    }


    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
