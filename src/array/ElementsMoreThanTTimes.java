package array;

import java.util.Scanner;


public class ElementsMoreThanTTimes {

    static class Pair {
        int element, frequency;

        public Pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printElementsAppearingMoreThanTTimes(arr, n, k);
    }

    private static void printElementsAppearingMoreThanTTimes(int[] arr, int n, int k) {
        int t = n / k;
        Pair[] elementFrequency = new Pair[k - 1];

        for (int i = 0; i < k - 1; i++) {
            elementFrequency[i] = new Pair(Integer.MAX_VALUE, 0);
        }

        for (int i = 0; i < n; i++) {
            int j;
            for (j = 0; j < k - 1; j++) {
                if (arr[i] == elementFrequency[j].element) {
                    elementFrequency[j].frequency++;
                    break;
                }
            }

            if (j == k - 1) {
                int l;

                for (l = 0; l < k - 1; l++) {
                    if (elementFrequency[l].frequency == 0) {
                        elementFrequency[l].element = arr[i];
                        elementFrequency[l].frequency = 1;
                        break;
                    }
                }

                if (l == k - 1) {
                    for (l = 0; l < k - 1; l++) {
                        elementFrequency[l].frequency--;
                    }
                }
            }
        }

        for (int i = 0; i < k - 1; i++) {
            int ct = 0;
            for (int j = 0; j < n; j++) {
                if (arr[j] == elementFrequency[i].element) {
                    ct++;
                }
            }

            if (ct > t) {
                System.out.print(elementFrequency[i].element + " ");
            }
        }


    }
}
