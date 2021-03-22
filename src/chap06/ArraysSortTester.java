package chap06;


import java.util.Arrays;
import java.util.Scanner;

public class ArraysSortTester {

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : "); int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] == "); x[i] = stdIn.nextInt();
        }

        Arrays.sort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] == " + x[i] + " / ");
        }
        System.out.println();

    }

}
