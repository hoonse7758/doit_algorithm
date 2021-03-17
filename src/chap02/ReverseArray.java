package chap02;


import java.util.Scanner;

public class ReverseArray {

    private static void swap(int[] arr, int idx1, int idx2) {

        System.out.println("arr[" + idx1 + "] 와 arr[" + idx2 + "] 를 교환합니다.");

        int t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void reverse(int[] arr) {
        for (int i = 0 ; i < arr.length / 2 ; i++) {
            swap(arr, i, arr.length - (i + 1));
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    static int sumOf(int[] arr) {
        int sum = 0;
        for (int element : arr) {
            sum += element;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("배열 요소 수 : "); int n = stdIn.nextInt();

        int[] x = new int[n];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        reverse(x);

        System.out.println("배열 요소들을 역순으로 재정렬하였습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

        System.out.println("모든 요소들의 총합은 " + sumOf(x) + " 입니다.");
    }
}
