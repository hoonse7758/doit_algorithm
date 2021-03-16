package chap01;

import java.util.Scanner;


public class TriangleLB {

    static void printLB(int len) {
        for(int i = 1 ; i < len + 1 ; i++) {
            for(int j = 1 ; j < i + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printLU(int len) {
        for(int i = 1 ; i < len + 1 ; i++) {
            for(int j = 1 ; j < (len - (i - 1)) + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printRU(int len) {
        for(int i = 1 ; i < len + 1 ; i++) {
            for(int j = 1; j < i ; j++) {
                System.out.print(" ");
            }
            for(int j = i; j < len + 1 ; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void printRB(int len) {
        for(int i = 1 ; i < len + 1 ; i++) {
            for(int j = 1 ; j < (len - (i - 1)) ; j++) {
                System.out.print(" ");
            }
            for(int j = (len - (i - 1)) ; j < len + 1 ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printPiramid(int len) {
        int floorLength = 2 * len - 1;
        int halfLength = len / 2;

        StringBuilder line;
        for(int i = 1; i < len + 1 ; i++) {
            line = new StringBuilder();
            line.append(" ".repeat(len - i));
            line.append("*".repeat(2 * i - 1));
            System.out.println(line);
        }
    }

    static void printPiramidNumber (int len) {
        int floorLength = 2 * len - 1;
        int halfLength = len / 2;

        StringBuilder line;
        for(int i = 1; i < len + 1 ; i++) {
            line = new StringBuilder();
            line.append(" ".repeat(len - i));
            line.append(Integer.toString(i).repeat(2 * i - 1));
            System.out.println(line);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("왼쪽 아래가 직각인 이등변 삼각형을 출력합니다.");
        int len;
        do {
            System.out.print("len = "); len = stdIn.nextInt();
            if (len <= 0) {
                System.out.println("len 값은 양의 정수만 입력 가능합니다.");
            }
        } while (len <= 0);

        System.out.println("왼쪽 아래 직각");
        printLB(len);
        System.out.println("왼쪽 위 직각");
        printLU(len);
        System.out.println("오른쪽 위 직각");
        printRU(len);
        System.out.println("오른쪽 아래 직각");
        printRB(len);
        System.out.println("피라미드");
        printPiramid(len);
        System.out.println("숫자피라미드");
        printPiramidNumber(len);
    }
}
