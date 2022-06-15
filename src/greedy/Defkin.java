package greedy;

import java.util.*;

public class Defkin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int w = sc.nextInt();
            int h = sc.nextInt();

            int n = sc.nextInt();
            int ct = n;

            int[] hArr = new int[n + 2];
            int[] vArr = new int[n + 2];
            int i = 0;
            hArr[0] = 0;
            vArr[0] = 0;
            i++;
            while (ct-- > 0) {
                hArr[i] = sc.nextInt();
                vArr[i] = sc.nextInt();

                i++;
            }

            hArr[n + 1] = w + 1;
            vArr[n + 1] = h + 1;

            Arrays.sort(hArr);
            Arrays.sort(vArr);

            int hMax = 0, vMax = 0;

            for (i = 0; i < hArr.length - 1; i++) {
                int hd = hArr[i + 1] - hArr[i] - 1;
                int vd = vArr[i + 1] - vArr[i] - 1;

                if (hd > hMax) {
                    hMax = hd;
                }

                if (vd > vMax) {
                    vMax = vd;
                }
            }

            System.out.println(hMax * vMax);
        }
    }
}
