package string;

import java.util.*;

public class AreIsomorphicStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(areIsomorphic(str1, str2));
    }

    private static boolean areIsomorphic(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }

        int len = str1.length();

        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < len; i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if (map1.containsKey(c1) && map1.get(c1) != c2 || map2.containsKey(c2) && map2.get(c2) != c1) {
                return false;
            } else {
                map1.put(c1, c2);
                map2.put(c2, c1);
            }
        }

        return true;
    }
}
