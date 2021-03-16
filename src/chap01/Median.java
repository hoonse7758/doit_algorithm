package chap01;

import java.util.Scanner;


public class Median {
    static int med3(int a1, int a2, int a3) {
        int med = 0;

        if (a1 >= a2) {
            if (a2 >= a3) {
                med = a2;
            } else if (a1 <= a3) {
                med = a1;
            } else {
                med = a3;
            }
        } else if (a1 > a3) {
            med = a1;
        } else if (a2 > a3) {
            med = a3;
        } else {
            med = a2;
        }

        return med;
    }

    static int med3_csh(int a1, int a2, int a3) {
        int med;

        if (a1 < a2) {
            if (a2 > a3) {
                // max(a1, a3) < a2
                if (a1 > a3) {
                    med = a1;
                } else {
                    med = a3;
                }
            } else {
                // a1 < a2 <= a3
                med = a2;
            }
        } else if (a1 == a2) {
            med = a2;
        } else {
            // a1 > a2
            if (a3 > a2) {
                // min(a1, a3) > a2
                if (a1 < a3) {
                    // a2 < a1 < a3
                    med = a1;
                } else {
                    med = a3;
                }
            } else {
                // a3 <= a2 < a1
                med = a2;
            }
        }

        return med;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in) ;

        System.out.println("세 정수의 중앙값을 구합니다.");

        System.out.print("a1 = "); int a1 = stdIn.nextInt();
        System.out.print("a2 = "); int a2 = stdIn.nextInt();
        System.out.print("a3 = "); int a3 = stdIn.nextInt();

        System.out.println("세 정수의 중앙값은 " + med3_csh(a1, a2, a3) + " 입니다.");
    }
}
