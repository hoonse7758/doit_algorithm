package chap05;

import java.util.Scanner;

public class Factorial {
    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else
            return 1;
    }

    static int factorialByLoop(int n) {
        int ret = n;
        while (--n > 0) {
            ret *= n;
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : "); int n = stdIn.nextInt();

        System.out.println(n + "! == " + factorialByLoop(n));

    }
}
