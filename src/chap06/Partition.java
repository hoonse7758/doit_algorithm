package chap06;

import java.util.Scanner;

public class Partition {

    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void partition(int[] arr) {
        int pl = 0;
        int pr = arr.length - 1;
        int x = arr[arr.length / 2];

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        System.out.println("PIVOT : arr[" + arr.length + "] == " + x);

        System.out.println("<피벗 이하 그룹>");
        for (int i = 0 ; i < pl ; i++) {
            System.out.print("arr[" + i + "] == " + arr[i] + " / ");
        }
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("<피벗 일치 그룹>");
            for (int i = pr + 1 ; i < pl ; i++) {
                System.out.print("arr[" + i + "] == " + arr[i] + " / ");
            }
            System.out.println();
        }

        System.out.println("<피벗 이상 그룹>");
        for (int i = pr + 1 ; i < arr.length ; i++) {
            System.out.print("arr[" + i + "] == " + arr[i] + " / ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요소 수 : "); int nx = stdIn.nextInt();

        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        partition(x);

//        System.out.println("오름차순으로 정렬했습니다.");
//        for (int i = 0 ; i < x.length ; i++) {
//            System.out.print("x[" + i + "] = " + x[i] + " / ");
//        }
    }

}
