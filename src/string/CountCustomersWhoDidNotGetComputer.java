package string;

import java.util.*;

public class CountCustomersWhoDidNotGetComputer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.set(i, sc.nextInt());
        }

        int k = sc.nextInt();

        System.out.println(countCustomers(arr, k));

    }

    public static int countCustomers(ArrayList<Integer> arr, int k) {
        int n = arr.size();

        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> comps = new HashSet<>();

        int j = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (left.contains(arr.get(i))) {
                continue;
            }

            if (comps.contains(arr.get(i))) {
                comps.remove(arr.get(i));
                j--;
            } else if (j < k) {
                comps.add(arr.get(i));
                j++;
            } else {
                left.add(arr.get(i));
            }
        }

        return left.size();
    }
}
