package string;

import java.util.*;

public class DuplicatesString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        printDuplicates(str, str.length());
    }

    private static void printDuplicates(String str, int n) {
        HashMap<Character, Integer> cMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);

            cMap.put(ch, cMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : cMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print(entry + " ");
            }
        }
    }
}
