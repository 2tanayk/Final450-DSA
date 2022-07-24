package bitmanipulation;

import java.util.*;

public class PowerSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(AllPossibleStrings(s));
    }

    public static List<String> AllPossibleStrings(String s) {
        List<String> ans = new ArrayList<>();


        int ct = (int) Math.pow(2, s.length()) - 1;

        for (int i = 1; i <= ct; i++) {
            StringBuilder temp = new StringBuilder();

            int cNum = i;
            int j = 0;

            while (cNum > 0) {
                if ((cNum & 1) > 0) {
                    temp.append(s.charAt(j));
                }
                j++;
                cNum = cNum >> 1;
            }

            ans.add(temp.toString());
        }

        Collections.sort(ans);

        return ans;
    }
}
