package string;

import java.util.*;

public class RomanToInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(romanToInt(s));
    }


    public static int romanToInt(String s) {
        int len = s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        char[] arr = s.toCharArray();

        int i = 0, res = 0;

        while (i < len) {
            if (i + 1 < len && map.get(arr[i]) < map.get(arr[i + 1])) {
                res -= map.get(arr[i]);
            } else {
                res += map.get(arr[i]);
            }
            i++;
        }

        return res;
    }
}
