package chap06;


import chap04.IntStack;

import java.util.Scanner;

public class QuickSort {

    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static int[] slice(int[] arr, int from, int to) {
        int[] ret = new int[to - (from - 1)];

        for (int i = from ; i < to + 1 ; i++) {
            ret[i - from] = arr[i];
        }

        return ret;
    }

    static void quickSortNoRecurVerbose(int[] arr) {
        quickSortNoRecurVerbose(arr, 0, arr.length - 1);
    }

    static void quickSortNoRecurVerbose(int[] arr, int left, int right) {
        IntStack lstack = new IntStack(right - (left - 1));
        IntStack rstack = new IntStack(right - (left - 1));

        lstack.push(left);
        rstack.push(right);

        System.out.printf("a[%d]~a[%d]를 분할하는 문제를 스택에 푸시합니다.\n", left, right);
        System.out.print("Lstack:");
        lstack.dump();
        System.out.print("Rstack:");
        rstack.dump();

        while (!lstack.isEmpty()) {
            int pl = left = lstack.pop();
            int pr = right = rstack.pop();
            int x = arr[(left + right) / 2];

            System.out.printf("스택에서 분할하는 문제를 꺼냈습니다.a[%d]~a[%d]를 분할합니다.\n", left, right);

            do {
                while (arr[pl] < x) pl++;
                while (arr[pr] > x) pr--;
                if (pl <= pr)
                    swap(arr, pl++, pr--);
            } while (pl <= pr);

            if (left < pr) {
                if (pl < right) {
                    if (pr - left > right - pl) {
                        lstack.push(left);
                        rstack.push(pr);
                        lstack.push(pl);
                        rstack.push(right);
                        System.out.print("Lstack:");
                        lstack.dump();
                        System.out.print("Rstack:");
                        rstack.dump();
                    } else {
                        lstack.push(pl);
                        rstack.push(right);
                        lstack.push(left);
                        rstack.push(pr);
                        System.out.print("Lstack:");
                        lstack.dump();
                        System.out.print("Rstack:");
                        rstack.dump();
                    }
                } else {
                    lstack.push(left);
                    rstack.push(pr);
                    System.out.print("Lstack:");
                    lstack.dump();
                    System.out.print("Rstack:");
                    rstack.dump();
                }
            } else {
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                    System.out.print("Lstack:");
                    lstack.dump();
                    System.out.print("Rstack:");
                    rstack.dump();
                }
            }
        }
    }

//    static void quickSortNoRecurVerbose(int[] arr) {
//        quickSortNoRecur(arr, 0, arr.length - 1);
//    }
//
//    static void quickSortNoRecurVerbose(int[] arr, int left, int right) {
//        IntStack lstack = new IntStack(right - (left - 1));
//        IntStack rstack = new IntStack(right - (left - 1));
//
//        lstack.push(left);
//        rstack.push(right);
//
//        while (!lstack.isEmpty()) {
//            int pl = left = lstack.pop();
//            int pr = right = rstack.pop();
//            int x = arr[(left + right) / 2];
//
//            do {
//                while (arr[pl] < x) pl++;
//                while (arr[pr] > x) pr--;
//                if (pl <= pr)
//                    swap(arr, pl++, pr--);
//            } while (pl <= pr);
//
//            if (left < pr) {
//                lstack.push(left);
//                rstack.push(pr);
//            }
//            if (pl < right) {
//                lstack.push(pl);
//                rstack.push(right);
//            }
//        }
//    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int x = arr[(pl + pr) / 2];

        System.out.printf("arr[%d] ~ arr[%d] : { ", left, right);
        for (int i = left ; i < right ; i++) {
            System.out.printf("%3d, ", arr[i]);
        }
        System.out.printf("%3d }\n", arr[right]);

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) {
            if (pl < right) {
                if (pr - left < right - pl) {
                    quickSort(arr, pl, right);
                    quickSort(arr, left, pr);
                } else {
                    quickSort(arr, left, pr);
                    quickSort(arr, pl, right);
                }
            } else {
                quickSort(arr, left, pr);
            }
        } else {
            if (pl < right) {
                quickSort(arr, pl, right);
            }
        }

//        if (left < pr) quickSort(arr, left, pr);
//        if (pl < right) quickSort(arr, pl, right);
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요소 수 : "); int nx = stdIn.nextInt();

        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        quickSort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = " + x[i] + " / ");
        }
    }

}
