package chap01;

import java.util.Scanner;


public class Digits {

    static int getNumberOfDigits(int number) {
        return (int) Math.floor(Math.log10(number)) + 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int no;
        boolean is_2digit = true;

        System.out.println("2자리 정수를 입력하세요.");
        do {
            System.out.print("no = "); no = stdIn.nextInt();
            is_2digit = getNumberOfDigits(no) == 2;
            if (!is_2digit) {
                System.out.println("2자리 정수만 입력 가능합니다.");
            }
        } while (!is_2digit);

        System.out.println("변수 no 의 값은 " + no + " 입니다.");
    }
}
