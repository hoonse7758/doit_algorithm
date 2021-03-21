package chap05;

import java.util.Scanner;

public class EuclidGCD {

    static int gcd(int n, int m) {
        if (m == 0)
            return n;
        else
            return gcd(m, n % m);
    }

    static int gcdByLoop(int n, int m) {
        int tmp;
        while (m > 0) {
            tmp = m;
            m = n % m;
            n = tmp;
        }
        return n;
    }

    static int gcdArray(int[] arr) {

        int ret = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            ret = gcd(ret, arr[i]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("첫번째 정수를 입력하세요 : "); int n = stdIn.nextInt();
        System.out.print("두번째 정수를 입력하세요 : "); int m = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcdByLoop(n, m) + " 입니다.");

        int[] arr = {3, 6, 18};
        System.out.print("배열 [ ");
        for (int integer : arr) {
            System.out.print(integer + ", ");
        }
        System.out.print(" ] 의 최대공약수는 " + gcdArray(arr) + " 입니다.");
    }

}
