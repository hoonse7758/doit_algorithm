package chap05;

import chap04.IntStack;

import java.util.Scanner;

public class Recur {

    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println("println : " + n);
            recur(n - 2);
        }
    }

    static void recurNoRecur(int n) {
        IntStack s = new IntStack(n);

        while (true) {
            if (n > 0) {
                s.push(n);
                n--;
                continue;
            }
            if (!s.isEmpty()) {
                n = s.pop();
                System.out.println(n);
                n -= 2;
                continue;
            }
            break;
        }
    }

    static void recur3(int n) {
        if (n > 0) {
            recur3(n - 1);
            recur3(n - 2);
            System.out.println(n);
        }
    }

    static void recur3NoRecur(int n) {
        IntStack stk = new IntStack(n);
        while (true) {
            if (n > 0) {
                stk.push(n--);
                continue;
            }
            n = stk.pop();
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : "); int x = stdIn.nextInt();

        System.out.println("recur3NoRecur");
        recur3NoRecur(x);
    }
}
