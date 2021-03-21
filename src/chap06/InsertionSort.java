package chap06;


import java.util.Scanner;

public class InsertionSort {

    static int binSearchX(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;
        int pc;

        do {
            pc = (pl + pr) / 2;

            if (arr[pc] == key){
                int locator = 0;
                while (pc - locator > 0) {
                    if (arr[pc - ++locator] < key)
                        break;
                }
                return pc - (locator - 1);
            }
            else if (arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr) ;

        return -1;
    }

    static void insertionSort(int[] arr) {
        for (int i = 1 ; i < arr.length ; i++) {
            int j;
            int tmp = arr[i];
            for (j = i ; j > 0 && arr[j - 1] > tmp ; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = tmp;
        }
    }

    static void sentinelInsertionSort(int[] arr) {

    }

    static void binaryInsertionSort(int[] arr) {

    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요소 수 : "); int nx = stdIn.nextInt();

        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        insertionSort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = " + x[i] + " / ");
        }
    }

}
