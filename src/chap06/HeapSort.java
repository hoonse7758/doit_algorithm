package chap06;


import java.util.Scanner;

public class HeapSort {

    static void swap(int[] arr, int idx1, int idx2) {
        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    // 2의 n 제곱을 구합니다
    static int pow2(int n) {
        int k = 1;

        while (n-- > 0)
            k *= 2;
        return (k);
    }

    // n개의 스페이스를 출력
    static void dispSpace(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(' ');
    }

    // 힙을 출력
    static void dispHeap(int a[]) {
        int i = a.length;
        int height = 1; // 트리의 높이
        while ((i >>= 1) > 0)
            height++;
        i = 0;
        int w = 1;
        Loop: {
            for (int level = 0; level < height; level++) {
                dispSpace(pow2(height - level) - 3);
                for (int k = 0; k < w; k++) {
                    System.out.printf("%02d", a[i++]);
                    if (i >= a.length)
                        break Loop;
                    if (k < w - 1)
                        dispSpace(pow2(height - level + 1) - 2);
                }
                System.out.println();

                dispSpace(pow2(height - level) - 4);
                for (int k = 0; k < w; k++) {
                    if (2 * k + i < a.length)
                        System.out.print(" ／ ");
                    if (2 * k + i + 1 < a.length)
                        System.out.print(" ＼ ");
                    if (k < w - 1)
                        dispSpace(pow2(height - level + 1) - 4);
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }

    static void dumpHeap(int[] arr) {
        int tmp = 0;
        int depth = 0;
        while (tmp < arr.length) {
            tmp += Math.pow(2, ++depth);
        }
        System.out.println("depth == " + depth);

        for (int d = 0 ; d < depth ; d++) {
            int dCnt = 0;
            while (dCnt < Math.pow(2, d)) {
                System.out.printf("%4d", arr[(int)Math.pow(2, d) + dCnt - 1]);
                dCnt++;
            }
            System.out.println();
        }
    }

    static void downHeap(int[] arr, int left, int right) {
        int tmp = arr[left];
        int child;
        int parent;

        dispHeap(arr);

        for (parent = left ; parent < (right + 1) / 2 ; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && arr[cr] > arr[cl]) ? cr: cl;
            if (tmp >= arr[child])
                break;
            arr[parent] = arr[child];
        }
        arr[parent] = tmp;
    }

    static void heapSort(int[] arr) {
        for (int i = (arr.length - 1) / 2 ; i >= 0 ; i--) {
            downHeap(arr, i, arr.length - 1);
        }

        for (int i = arr.length - 1 ; i > 0 ; i--) {
            swap(arr, 0, i);
            downHeap(arr, 0, i - 1);
        }
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");

        System.out.print("요소 수 : "); int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] == "); x[i] = stdIn.nextInt();
        }

        heapSort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.println("x[" + i + "] == " + x[i]);
        }

    }

}
