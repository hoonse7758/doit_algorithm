package chap02;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayEqual {
    static boolean equals(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0 ; i < arr1.length ; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    static void copy(int[] tgtArr, int[] srcArr) {
        int n = Math.min(tgtArr.length, srcArr.length);

        // System.arraycopy(srcArr, 0, tgtArr, 0, n);
        for (int i = 0 ; i < n ; i++) {
            tgtArr[i] = srcArr[i];
        }
    }

    static void rcopy(int[] tgtArr, int[] srcArr) {
        int n = Math.min(tgtArr.length, srcArr.length);

        // System.arraycopy(srcArr, 0, tgtArr, 0, n);
        for (int i = 0 ; i < n ; i++) {
            tgtArr[i] = srcArr[srcArr.length - (i + 1)];
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        // case 1
        int[] copy1_src = new int[]{1, 5, 4, 2, 3};
        int[] copy1_tgt = new int[6];
        int[] copy1_tgt_rev = new int[6];
        copy(copy1_tgt, copy1_src);
        rcopy(copy1_tgt_rev, copy1_src);
        System.out.println("case1 >> " + Arrays.toString(copy1_tgt));
        System.out.println("case1 >> " + Arrays.toString(copy1_tgt_rev));

        // case 2
        int[] copy2_src = new int[]{1, 5, 4, 2, 3};
        int[] copy2_tgt = new int[5];
        int[] copy2_tgt_rev = new int[5];
        copy(copy2_tgt, copy2_src);
        rcopy(copy2_tgt_rev, copy1_src);
        System.out.println("case2 >> " + Arrays.toString(copy2_tgt));
        System.out.println("case1 >> " + Arrays.toString(copy2_tgt_rev));

        // case 3
        int[] copy3_src = new int[]{1, 5, 4, 2, 3};
        int[] copy3_tgt = new int[3];
        int[] copy3_tgt_rev = new int[3];
        copy(copy3_tgt, copy3_src);
        rcopy(copy3_tgt_rev, copy1_src);
        System.out.println("case3 >> " + Arrays.toString(copy3_tgt));
        System.out.println("case1 >> " + Arrays.toString(copy3_tgt_rev));


        System.out.print("배열 a 의 요소수 : "); int nA = stdIn.nextInt();
        int[] a = new int[nA];
        for (int i = 0 ; i < a.length ; i++) {
            System.out.print("a[" + i + "] = "); a[i] = stdIn.nextInt();
        }

        System.out.print("배열 b 의 요소수 : "); int nB = stdIn.nextInt();
        int[] b = new int[nB];
        for (int i = 0 ; i < b.length ; i++) {
            System.out.print("b[" + i + "] = "); b[i] = stdIn.nextInt();
        }

        System.out.println("배열 a 와 배열 b 는 " + (equals(a, b) ? "같습니다." : "다릅니다."));

    }
}
