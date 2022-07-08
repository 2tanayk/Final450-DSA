package graph;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        int k = sc.nextInt();

        System.out.println(findOrder(arr, n, k));
    }

    public static String findOrder(String[] arr, int n, int k) {
        StringBuilder ans = new StringBuilder();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        int j = -1;

        for (int i = 0; i < n - 1; i++) {
            String a = arr[i];
            String b = arr[i + 1];

            j = 0;

            while (j < a.length() && j < b.length()) {
                char c1 = a.charAt(j);
                char c2 = b.charAt(j);


                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
                j++;
            }
        }


        boolean[] vis = new boolean[k];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < k; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis, st);
            }
        }

        while (!st.isEmpty()) {
            ans.append((char) (st.pop() + 'a'));
        }

        return ans.toString();
    }


    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis, Stack<Integer> s) {
        vis[i] = true;

        for (Integer e : adj.get(i)) {
            if (!vis[e]) {
                dfs(adj, e, vis, s);
            }
        }

        s.push(i);
    }
}
