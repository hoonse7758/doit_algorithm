package chap06;


import java.util.Scanner;

public class ShellSort {

    static void shellSort(int[] arr) {

        int cntSwap = 0;

        for (int h = arr.length / 2 ; h > 0 ; h /= 2) {
            System.out.println("h == " + h);
            for (int i = h ; i < arr.length ; i++) {
                int j;
                int tmp = arr[i];
                for (j = i - h ; j >= 0 && arr[j] > tmp ; j -= h) {
                    cntSwap++;
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
        }

        System.out.println("총 " + cntSwap + " 회의 이동이 발생하였습니다.");
    }

    static void shellSortVer2(int[] arr) {

        int cntSwap = 0;

        int h;
        for (h = 1 ; h < arr.length / 9 ; h = h * 3 + 1)
            ;
        System.out.println("h == " + h);

        for ( ; h > 0 ; h /= 3) {
            for (int i = h ; i < arr.length ; i++) {
                int j;
                int tmp = arr[i];
                for (j = i - h ; j >= 0 && arr[j] > tmp ; j -= h) {
                    cntSwap++;
                    arr[j + h] = arr[j];
                }
                arr[j + h] = tmp;
            }
        }

        System.out.println("총 " + cntSwap + " 회의 이동이 발생하였습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("버블 정렬 (버전 1)");
        System.out.print("요소 수 : "); int nx = stdIn.nextInt();

        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        shellSort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = " + x[i] + " / ");
        }
    }

}
