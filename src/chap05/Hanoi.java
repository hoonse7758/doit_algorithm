package chap05;

import chap04.IntStack;

import java.util.Scanner;

public class Hanoi {

    static void moveLoop(int no, int x, int y) {
        IntStack stk = new IntStack(no);
        int tmp;

        while (true) {
            if (no > 1) {
                stk.push(no);
                no--;
                continue;
            }
            no = stk.pop();
            tmp = y;
            y = 6 - (x + y);
            System.out.println("원반 [" + no + "] 를 기둥 <" + (char) (64 + x) + "> 에서 기둥 <" + (char) (64 + y) + "> 로 옮김.");
            if (no > 1) {
                no--;
                tmp = x;
                x = 6 - (x + y);
                continue;
            }
            break;
        }
    }

    static void move(int no, int x, int y) {

        if (no > 1) {
            move(no - 1, x, 6 - (x + y));
        }
        System.out.println("원반 [" + no + "] 를 기둥 <" + (char) (64 + x) + "> 에서 기둥 <" + (char) (64 + y) + "> 로 옮김.");

        if (no > 1) {
            move(no - 1, 6 - (x + y), y);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반 개수 : "); int n = stdIn.nextInt();

        moveLoop(n, 1, 3);
    }

}
