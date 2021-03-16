package chap01;

import java.util.Scanner;

public class Max3 {
    public static void main (String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최대값을 구합니다.");

        System.out.print("a1 = "); int a1 = stdIn.nextInt();
        System.out.print("a2 = "); int a2 = stdIn.nextInt();
        System.out.print("a3 = "); int a3 = stdIn.nextInt();

        int max = a1;
        if (a2 > max) max = a2 ;
        if (a3 > max) max = a3 ;

        System.out.println("최대값은 " + max + " 입니다 !");
    }
}
