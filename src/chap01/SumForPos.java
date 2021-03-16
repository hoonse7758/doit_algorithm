package chap01;

import java.util.Scanner;


public class SumForPos {

    static int getNumberOfDigits(int number) {
        return (int) Math.floor(Math.log10(number)) + 1;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int n;

        System.out.println("1 부터 n 까지의 합을 구합니다.");

        do {
            System.out.print("n = "); n = stdIn.nextInt();
            if (n <= 0) {
                System.out.println("n 은 양의 정수만 가능합니다.");
            }
        } while (n <= 0);

        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += i;
        }

        System.out.println("1 부터 n 까지의 합은 " + sum);

        System.out.println("Q1");
        int a;
        int b;
        do {
            System.out.print("a = "); a = stdIn.nextInt();
            System.out.print("b = "); b = stdIn.nextInt();
            if (b <= a) {
                System.out.println("b 는 a 보다 커야 합니다.");
            }
        } while (b <= a);
        System.out.println("b - a = " + b + " - " + a + " = " + (b - a));

        System.out.println("Q2");
        int number;
        do {
            System.out.print("number = "); number = stdIn.nextInt();
            if (number <= 0) {
                System.out.println("number 값은 양의 정수만 입력 가능합니다.");
            }
        } while (number <= 0);
        System.out.println("n = " + n + " 은 " + getNumberOfDigits(number) + " 자리 자연수입니다.");
    }
}
