package chap03;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchTester {

    static protected int getInsertionIdx(int[] arr, int key) {
        int i;
        for (i = 0 ; i < arr.length ; i++) {
            if (arr[i] >= key)
                break;
        }
        return -i - 1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : "); int n = stdIn.nextInt();

        int[] x = new int[n];

        System.out.println("오름차순으로 입력해주세요.");
        System.out.print("x[0] : "); x[0] = stdIn.nextInt();
        for (int i = 1 ; i < x.length ; i++) {
            do {
                System.out.print("x[" + i + "] : "); x[i] = stdIn.nextInt();
            } while (x[i - 1] > x[i]);
        }

        System.out.print("검색할 값 : "); int key = stdIn.nextInt();

        int idx = Arrays.binarySearch(x, key);
        if (idx < 0) {
            System.out.println("그런 값은 없습니다. 삽입 포인트 = " +  getInsertionIdx(x, key));
        } else {
            System.out.println(key + " 는 x[" + idx + "] 에 있습니다.");
        }
    }

}
