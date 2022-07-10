package graph;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class JourneyToTheMoon {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */
    static int ct = 0;

    public static long journeyToMoon(int n, List<List<Integer>> arr) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < arr.size(); i++) {
            adj.get(arr.get(i).get(0)).add(arr.get(i).get(1));
            adj.get(arr.get(i).get(1)).add(arr.get(i).get(0));
        }

        boolean[] vis = new boolean[n];

        long pairs = 0;
        long sets = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(adj, i, vis);
                pairs += (sets * ct);
                sets += ct;
                ct = 0;
            }
        }


        return pairs;
    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, int i, boolean[] vis) {
        ct++;
        vis[i] = true;

        for (Integer e : adj.get(i)) {
            if (!vis[e]) {
                dfs(adj, e, vis);
            }
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = JourneyToTheMoon.journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
