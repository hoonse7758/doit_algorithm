package chap06;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Fsort {

    static int min(int[] arr) {
        int min = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] < arr[min])
                min = i;
        }
        return arr[min];
    }

    static int max(int[] arr) {
        int max = 0;
        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] > arr[max])
                max = i;
        }
        return arr[max];
    }

    static void printArray(String prefix, int[] arr) {
        System.out.println(prefix + Arrays.toString(arr));
    }

    static void fsort(int[] arr) {

        int arrMin = min(arr);
        int arrMax = max(arr);
        int[] f = new int[arrMax - (arrMin - 1)];
        int[] b = new int[arr.length];

        System.out.println("1. 도수 배열 구하기");
        for (int i = 0              ;   i < arr.length  ;   i++)
            f[arr[i] - arrMin]++;
        printArray("arr == ", arr);
        printArray("f == ", f);
        printArray("b == ", b);

        System.out.println("2. 누적도수 배열 구하기");
        for (int i = 1              ;   i < f.length    ;   i++)
            f[i] += f[i - 1];
        printArray("arr == ", arr);
        printArray("f == ", f);
        printArray("b == ", b);

        System.out.println("3. 정렬된 배열 구하기");
        for (int i = arr.length - 1 ;   i >= 0          ;   i--)
            b[--f[arr[i] - arrMin]] = arr[i];
        printArray("arr == ", arr);
        printArray("f == ", f);
        printArray("b == ", b);

        System.out.println("4. 정렬 결과 원본 배열에 반영하기");
        for (int i = 0              ;   i < arr.length  ;   i++)
            arr[i] = b[i];
        printArray("arr == ", arr);
        printArray("f == ", f);
        printArray("b == ", b);

    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("도수 정렬");

        System.out.print("요소 수 : "); int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        fsort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.println("x[" + i + "] = " + x[i]);
        }

    }

}
