package chap01;

import java.util.Scanner;


public class SumFor {

    static int sumForViz(int n) {
        int sum;
        sum = 1;
        String formula = Integer.toString(sum);
        for (int i = 2 ; i < n + 1 ; i++) {
            formula = formula + " + " + Integer.toString(i);
            sum += i;
        }
        formula = formula + " = " + Integer.toString(sum);
        System.out.println(formula);
        return sum;
    }

    static int sumForGaussian(int n) {
        int sum;
        sum = 0;

        // todo: fill this logic

        return sum;
    }

    static int sumForRange(int r1, int r2) {
        int from;
        int to;
        int sum = 0;

        if (r1 == r2) {
            return r1;
        } else {
            from = Math.min(r1, r2);
            to = Math.max(r1, r2);
        }

        for (int i = from; i < to + 1 ; i++) {
            sum += i;
        }
        System.out.println("sum = " + sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("Q1");
        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.print("n = "); int n = stdIn.nextInt();
        sumForViz(n);

        System.out.println("\nQ3");
        System.out.println("주어진 두 자연수 사이의 모든 자연수들을 더합니다..");
        System.out.print("r1 = "); int r1 = stdIn.nextInt();
        System.out.print("r2 = "); int r2 = stdIn.nextInt();
        sumForRange(r1, r2);

//        int sum = 0;
//        for (int i = 1 ; i < n + 1 ; i++) {
//            sum += i;
//        }
//        System.out.println("1 부터 n = " + n + " 까지의 합은 " + sum + " 입니다.");
    }
}
