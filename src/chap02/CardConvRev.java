package chap02;

import java.util.Scanner;

public class CardConvRev {

    static int cardConv(int x, int r, char[] d) {

        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf("%2d | %10d\n", r, x);
        System.out.println("---+-------------");
        do {

            if (x / r > 0) {
                System.out.printf("%2d | %10d ~ %2d\n", r, x / r, x % r);
                System.out.println("---+-------------");
            } else {
                System.out.printf("     %10d ~ %2d\n", x / r, x % r);
            }



            d[d.length - ++digits] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }

    static int cardConvR(int x, int r, char[] d) {

        int digits = 0;

        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        do {
            d[digits++] = dchar.charAt(x % r);
            x /= r;
        } while (x != 0);

        return digits;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int targetNumber;
        int cardinalNumber;
        int numberOfDigits;
        int retry;
        char[] cno;

        System.out.println("10 진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환할 음이 아닌 정수를 입력해주세요. : "); targetNumber = stdIn.nextInt();
                if (targetNumber < 0)
                    System.out.println("변환 대상 값은 음이 아닌 정수여야 합니다.");
            } while (targetNumber < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : "); cardinalNumber = stdIn.nextInt();
                if (cardinalNumber < 2 || cardinalNumber > 36)
                    System.out.println("2 ~ 36 사이의 값을 입력해주세요.");
            } while (cardinalNumber < 2 || cardinalNumber > 36);

//            numberOfDigits = cardConvR(targetNumber, cardinalNumber, cno);
//            System.out.print(cardinalNumber + " 진수로 변환 결과는 ");
//            for (int i = numberOfDigits - 1 ; i >= 0 ; i--) {
//                System.out.print(cno[i]);
//            }
//            System.out.println(" 입니다.");

            cno = new char[32];
            numberOfDigits = cardConv(targetNumber, cardinalNumber, cno);
            System.out.print(cardinalNumber + " 진수로 변환 결과는 ");
            for (int i = 0 ; i < cno.length ; i++) {
                System.out.print(cno[i]);
            }
            System.out.println(" 입니다.");

            do {
                System.out.print("\n한번 더 할까요? (1.Yes/0.No) : "); retry = stdIn.nextInt();
                if (retry < 0 || retry > 1) {
                    System.out.println("1 또는 0 값만 입력해주세요.");
                }
            } while (retry < 0 || retry > 1);
        } while (retry == 1);
    }
}
