package chap01;

import java.util.Scanner;


public class SumWhile {
    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.println("1 부터 n 까지의 합을 구합니다.");
        System.out.print("n = "); int n = stdIn.nextInt();

        int i = 0;
        int sum = 0;
        while (i < n + 1) {
            sum += i;
            System.out.println("i = " + i + " / sum = " + sum);
            i += 1;
        }

        System.out.println("final i = " + i);

    }
}
