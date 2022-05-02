package greedy;

import java.util.*;

public class MaxIStocksIthDay {

    private static class Stock {
        int price, max;

        public Stock(int price, int max) {
            this.price = price;
            this.max = max;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(maxStocks(n, k, prices));
    }

    private static int maxStocks(int n, int k, int[] prices) {
        int ct = 0;

        Stock[] stocks = new Stock[n];

        for (int i = 0; i < n; i++) {
            stocks[i] = new Stock(prices[i], (i + 1));
        }

        Arrays.sort(stocks, Comparator.comparingInt(e -> e.price));

        for (Stock stock : stocks) {
            int price = stock.price;
            int max = stock.max;

            if ((k - price * max) >= 0) {
                ct += max;
                k -= (price * max);
            } else {
                while ((k - price) >= 0) {
                    k -= price;
                    ct++;
                }
            }
        }

        return ct;
    }
}
