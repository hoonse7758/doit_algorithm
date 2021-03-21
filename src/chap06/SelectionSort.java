package chap06;


import java.util.Scanner;

public class SelectionSort {

    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void selectionSort(int[] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            int min = i;
            for (int j = i + 1 ; j < arr.length ; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    static void selectionSortVerbose(int[] arr) {
        int k;
        for (int i = 0 ; i < arr.length ; i++) {
            int min = i;
            for (int j = i + 1 ; j < arr.length ; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            for (k = 0 ; k < arr.length ; k++) {
                System.out.print((k == i) ? "  *": (k == min) ? "  +": "   ");
            }
            System.out.println();
            for (k = 0 ; k < arr.length ; k++) {
                System.out.printf("%3d", arr[k]);
            }
            System.out.println();
            swap(arr, i, min);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요소 수 : "); int nx = stdIn.nextInt();

        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        selectionSortVerbose(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = " + x[i] + " / ");
        }
    }
}
