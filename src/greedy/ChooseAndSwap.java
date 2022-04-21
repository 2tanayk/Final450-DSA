package greedy;

import java.util.*;

class ChooseAndSwap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(chooseAndSwap(str));
    }

    private static String chooseAndSwap(String s) {
        String ans = "";
        int n = s.length();
        int[] arr = new int[26];
        Arrays.fill(arr, -1);

        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (arr[cur - 'a'] == -1) {
                arr[cur - 'a'] = i;
            }
        }

        int i = 0, j = 0;
        for (i = 0; i < n; i++) {
            char cur = s.charAt(i);
            boolean flag = false;

            for (j = 0; j < cur - 'a'; j++) {
                if (arr[j] > arr[cur - 'a']) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }

        if (i < n) {
            char ch1 = s.charAt(i);
            char ch2 = (char) (j + 'a');
            for (int k = 0; k < n; k++) {
                char cur = s.charAt(k);
                if (cur == ch1) {
                    ans += ch2;
                } else if (cur == ch2) {
                    ans += ch1;
                } else {
                    ans += cur;
                }
            }
            return ans;
        }

        return s;
    }
}