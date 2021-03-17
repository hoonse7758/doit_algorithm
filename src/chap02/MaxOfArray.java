package chap02;


import java.util.Scanner;

public class MaxOfArray {
    static int maxOf(int[] arr) {
        int max = arr[0];

        for (int i = 1 ; i < arr.length ; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("키의 최대 값을 구합니다.");
        System.out.print("사람 수 : "); int num = stdIn.nextInt();

        int[] height = new int[num];

        for (int i = 0 ; i < num ; i++) {
            System.out.print("height[" + i + "] : "); height[i] = stdIn.nextInt();
        }

        System.out.println("최대값은 " + maxOf(height) + " 입니다.");
    }
}
