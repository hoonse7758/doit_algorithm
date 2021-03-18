package chap02;


import java.util.Arrays;
import java.util.Scanner;

public class YMD {

    protected int year;
    protected int month;
    protected int day;

    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
    };

    public YMD(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

//    YMD after(int d) {
//
//        int year;
//        int month;
//        int day;
//        int afterDayOfYear = getDayOfYear(this.year, this.month, this.day) + d;
//        do {
//
//        } while (afterDayOfYear > 0);
//
//        return YMD();
//    }

//    YMD before(int d) {
//
//    }

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1: 0;
    }

    static int dayOfYear(int yyyy, int mm, int dd) {
        int days = dd;

        for (int i = 0 ; i < mm - 1 ; i++) {
            days += mdays[isLeap(yyyy)][i];
        }

        return days;
    }

    static int getDayOfYear(int yyyy, int mm, int dd) {

        while (--mm > 0) {
            dd += mdays[isLeap(yyyy)][mm - 1];
        }

        return dd;
    }

    static int leftDayOfYear(int yyyy, int mm, int dd) {
        return Arrays.stream(mdays[isLeap(yyyy)]).sum() - getDayOfYear(yyyy, mm, dd);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        int retry;
        int year;
        int month;
        int day;

        System.out.println("그 해 경과 일수를 구합니다.");

        do {
            System.out.println("년 : "); year = stdIn.nextInt();
            System.out.println("월 : "); month = stdIn.nextInt();
            System.out.println("일 : "); day = stdIn.nextInt();

            System.out.printf("그 해 %d 일 째입니다.\n", getDayOfYear(year, month, day));
            System.out.printf("그 해 %d 일 남았습니다.\n", leftDayOfYear(year, month, day));

            System.out.println("한번 더 할까요? (예: 1 / 아니오: 다른 키) : "); retry = stdIn.nextInt();

        } while (retry == 1);
    }

}
