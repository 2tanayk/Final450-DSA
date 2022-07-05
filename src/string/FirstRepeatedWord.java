package string;

import java.util.*;

public class FirstRepeatedWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(firstRepeatedString(s));
    }

    private static String firstRepeatedString(String s) {
        String[] arr = s.split(" ");

        HashSet<String> hs = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (!hs.contains(arr[i])) {
                hs.add(arr[i]);
            } else {
                return arr[i];
            }
        }

        return "-1";
    }
}
