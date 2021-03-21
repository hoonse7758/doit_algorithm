package chap06;


import java.awt.*;
import java.util.Scanner;

public class BubbleSort {

    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void bubbleSortReverse(int[] arr) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            for (int j = 0 ; j < arr.length - (i + 1) ; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    static void bubbleSort(int[] arr) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            for (int j = arr.length - 1 ; j > i ; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    static void bubbleSortVer2(int[] arr) {
        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int nExchange = 0;
            for (int j = arr.length - 1 ; j > i ; j--) {
                if (arr[j - 1] > arr[j]) {
                    nExchange++;
                    swap(arr, j - 1, j);
                }
            }
            if (nExchange == 0) {
                break;
            }
        }
    }

    static void bubbleSortVer3(int[] arr) {
        int k = 0;
        while (k < arr.length - 1) {
            int last = arr.length - 1;
            for (int j = arr.length - 1 ; j > k ; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    static void bubbleSortVer3Verbose(int[] arr) {

        int cntCompare = 0;
        int cntReverse = 0;

        int k = 0;
        int cntPath = 0;
        while (k < arr.length - 1) {
            int last = arr.length - 1;
            System.out.println("<Path " + ++cntPath + ">");
            for (int j = arr.length - 1 ; j > k ; j--) {
                int jj;
                for (jj = 0 ; jj < j ; jj++) {
                    System.out.printf("%5d", arr[jj]);
                }
                if (arr[j - 1] > arr[j]) {
                    System.out.printf(" + %2d", arr[j]);
                    swap(arr, j - 1, j);
                    last = j;
                } else {
                    System.out.printf(" - %2d", arr[j]);
                }
                for (jj = j + 1 ; jj < arr.length ; jj++) {
                    System.out.printf("%5d", arr[jj]);
                }
                System.out.println();
            }
            k = last;
        }

        System.out.println("\n<Result>");
        for (int l = 0 ; l < arr.length ; l++) {
            System.out.printf("%5d", arr[l]);
        }
        System.out.println("\n");

        System.out.println("비교 횟수 : " + cntCompare);
        System.out.println("교환 횟수 : " + cntReverse);
    }

    static void bubbleSortVer2Verbose(int[] arr) {

        int cntCompare = 0;
        int cntReverse = 0;

        for (int i = 0 ; i < arr.length - 1 ; i++) {
            int nExchange = 0;
            System.out.println("<Path " + (i + 1) + ">");
            for (int j = arr.length - 1 ; j > i ; j--) {
                int k;
                for (k = 0 ; k < j ; k++) {
                    System.out.printf("%5d", arr[k]);
                }
                cntCompare++;
                if (arr[j - 1] > arr[j]) {
                    System.out.printf(" + %2d", arr[j]);
                    nExchange++;
                    cntReverse++;
                    swap(arr, j - 1, j);
                } else {
                    System.out.printf(" - %2d", arr[j]);
                }
                for (k = j + 1 ; k < arr.length ; k++) {
                    System.out.printf("%5d", arr[k]);
                }
                System.out.println();
            }
            System.out.println();
            if (nExchange == 0) {
                System.out.println("더 이상 정렬할 요소가 없습니다. 루프를 벗어납니다.");
                break;
            }
        }

        System.out.println("\n<Result>");
        for (int l = 0 ; l < arr.length ; l++) {
            System.out.printf("%5d", arr[l]);
        }
        System.out.println("\n");

        System.out.println("비교 횟수 : " + cntCompare);
        System.out.println("교환 횟수 : " + cntReverse);
    }

    static void bubbleSortVerbose(int[] arr) {

        int cntCompare = 0;
        int cntReverse = 0;

        for (int i = 0 ; i < arr.length - 1 ; i++) {
            System.out.println("<Path " + (i + 1) + ">");
            for (int j = arr.length - 1 ; j > i ; j--) {
                int k;
                for (k = 0 ; k < j ; k++) {
                    System.out.printf("%5d", arr[k]);
                }
                cntCompare++;
                if (arr[j - 1] > arr[j]) {
                    System.out.printf(" + %2d", arr[j]);
                    cntReverse++;
                    swap(arr, j - 1, j);
                } else {
                    System.out.printf(" - %2d", arr[j]);
                }
                for (k = j + 1 ; k < arr.length ; k++) {
                    System.out.printf("%5d", arr[k]);
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.println("<Result>");
        for (int l = 0 ; l < arr.length ; l++) {
            System.out.printf("%5d", arr[l]);
        }
        System.out.println();

        System.out.println("비교 횟수 : " + cntCompare);
        System.out.println("교환 횟수 : " + cntReverse);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요소 수 : "); int nx = stdIn.nextInt();

        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        bubbleSortVer3Verbose(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = " + x[i] + " / ");
        }
    }

}
