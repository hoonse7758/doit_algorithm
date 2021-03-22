package chap06;


import java.util.Scanner;

public class MergeSort {

    static int[] buff;

    static void __mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(arr, left, center);
            __mergeSort(arr, center + 1, right);

            for (i = left ; i <= center ; i++) {
                buff[p++] = arr[i];
            }

            while (i <= right && j < p) {
                arr[k++] = (buff[j] <= arr[i]) ? buff[j++]: arr[i++];
            }

            while (j < p) {
                arr[k++] = buff[j++];
            }

        }
    }

    static void mergeSort(int[] arr) {
        buff = new int [arr.length];

        __mergeSort(arr, 0, arr.length - 1);

        buff = null;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");

        System.out.print("요소 수 : "); int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        mergeSort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

    }

}
