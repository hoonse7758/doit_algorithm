package chap02;

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
    static int maxOf(int[] arr) {
        int max = arr[0];

        for (int element : arr)
            if (element > max) max = element;

        return max;
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최대값을 구합니다.");
//        System.out.print("사람 수 : "); int n = stdIn.nextInt();
        int n = random.nextInt(10);
        System.out.println("사람 수 : " + n);

        int[] height = new int[n];

        System.out.println("키 값은 아래와 같습니다.");
        for (int i = 0 ; i < height.length ; i++) {
            height[i] = 100 + random.nextInt(90);
            System.out.println("height[" + i + "] = " + height[i]);
        }

        System.out.println("최대값은 " + maxOf(height) + " 입니다.");
    }
}
