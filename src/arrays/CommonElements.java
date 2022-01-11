package arrays;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int[] arr1 = new int[n1];

        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        int n2 = sc.nextInt();
        int[] arr2 = new int[n2];

        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        int n3 = sc.nextInt();
        int[] arr3 = new int[n3];

        for (int i = 0; i < n3; i++) {
            arr3[i] = sc.nextInt();
        }

        System.out.println(commonElements(arr1, arr2, arr3, n1, n2, n3));
    }

    private static ArrayList<Integer> commonElements(int arr1[], int arr2[], int arr3[], int n1, int n2, int n3) {
        ArrayList<Integer> tempList = new ArrayList<>();
        ArrayList<Integer> commonList = new ArrayList<>();
        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (int i = 0, j = 0; i < Math.max(arr1.length, arr2.length) && j < Math.max(arr1.length, arr2.length); ) {
            if (i < arr1.length && j < arr2.length && arr1[i] == arr2[j]) {
                tempList.add(arr1[i]);
                i++;
                j++;
            } else if (i < arr1.length && j < arr2.length && arr1[i] < arr2[j]) {
                i++;
            } else {
                j++;
            }
        }

        for (int i = 0, j = 0; i < Math.max(arr3.length, tempList.size()) && j < Math.max(arr3.length,
                tempList.size()); ) {
            if (i < arr3.length && j < tempList.size() && arr3[i] == tempList.get(j)) {
                commonList.add(arr3[i]);
                i++;
                j++;
            } else if (i < arr3.length && j < tempList.size() && arr3[i] < tempList.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        if (commonList.size() <= 1) {
            return commonList;
        }
        int prev = commonList.get(0);
        uniqueList.add(prev);
        for (int i = 1; i < commonList.size(); i++) {
            if (commonList.get(i) != prev) {
                uniqueList.add(commonList.get(i));
            }
            prev = commonList.get(i);
        }
        return uniqueList;
    }
}
