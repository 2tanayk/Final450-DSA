package string;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        System.out.println(groupAnagrams(arr));
    }

    public static List<List<String>> groupAnagrams(String[] arr) {
        int n = arr.length;

        List<List<String>> ans = new ArrayList<>();

        String[] cpy = arr.clone();

        HashMap<String, ArrayList<Integer>> imap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char[] stArr = arr[i].toCharArray();

            Arrays.sort(stArr);

            String tmp = String.valueOf(stArr);

            ArrayList<Integer> val;
            if (imap.containsKey(tmp)) {
                val = imap.get(tmp);
                val.add(i);
            } else {
                val = new ArrayList<>();
                val.add(i);
            }

            imap.put(tmp, val);
        }

        Set<String> keys = imap.keySet();

        for (String key : keys) {
            List<String> l = new ArrayList<>();
            for (int e : imap.get(key)) {
                l.add(arr[e]);
            }
            ans.add(l);
        }

        return ans;
    }
}
