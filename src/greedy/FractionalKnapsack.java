package greedy;

import java.util.*;

public class FractionalKnapsack {

    static class Item {
        int value, weight;

        public Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }

    static class ItemAndCost {
        int value, weight;
        Double cost;

        public ItemAndCost(int value, int weight) {
            this.value = value;
            this.weight = weight;
            cost = (double) value / (double) weight;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int w = sc.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        Item[] arr = new Item[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Item(values[i], weights[i]);
        }

        System.out.println(maxProfit(w, arr, n));
    }

    private static double maxProfit(int w, Item[] arr, int n) {
        double profit = 0.0;
        ItemAndCost[] items = new ItemAndCost[n];

        for (int i = 0; i < n; i++) {
            items[i] = new ItemAndCost(arr[i].value, arr[i].weight);
        }

        Arrays.sort(items, (o1, o2) -> o2.cost.compareTo(o1.cost));

        for (int i = 0; i < n; i++) {
            ItemAndCost cur = items[i];

            if (cur.weight <= w) {
                profit += cur.value;
                w -= cur.weight;
                if (w == 0) {
                    break;
                }
            } else {
                profit += (cur.value / (cur.weight * 1.0)) * w;
                break;
            }
        }
        return profit;
    }
}
