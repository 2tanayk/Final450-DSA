package string;

import java.util.*;

public class StringIsValidShuffleOf2Strings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        String s = sc.nextLine();

        System.out.println(isValidShuffle(s1, s2, s));
    }

    private static boolean isValidShuffle(String s1, String s2, String s) {
        int l1 = s1.length();
        int l2 = s2.length();
        int l = s.length();

        if (l != (l1 + l2)) {
            return false;
        }


        HashMap<Character, Integer> hashMapQues = new HashMap<>();
        HashMap<Character, Integer> hashMapRes = new HashMap<>();


        for (int i = 0; i < l1; i++) {
            char cur = s1.charAt(i);
            hashMapQues.put(cur, hashMapQues.getOrDefault(cur, 0) + 1);
        }

        for (int i = 0; i < l2; i++) {
            char cur = s2.charAt(i);
            hashMapQues.put(cur, hashMapQues.getOrDefault(cur, 0) + 1);
        }

        for (int i = 0; i < l; i++) {
            char cur = s.charAt(i);
            hashMapRes.put(cur, hashMapRes.getOrDefault(cur, 0) + 1);
        }
        
        return hashMapQues.equals(hashMapRes);
    }
}
