package chap03;


import java.util.Scanner;

public class SeqSearchSentinel {

    static int run(int[] arr, int n, int key) {

        arr[n] = key;

//        int i = 0;
//        while (true) {
//            if (arr[i] == key) {
//                break;
//            }
//            i++;
//        }
        int i;
        for (i = 0 ; i < arr.length ; i++) {
            if (arr[i] == key)
                break;
        }

        return i == n ? -1 : i;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : "); int num = stdIn.nextInt();

        int[] x = new int[num + 1];

        for (int i = 0 ; i < num ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : "); int key = stdIn.nextInt();

        int idx = run(x, num, key);
        if (idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("key = " + key + " 는 x[" + idx + "] 에 있습니다.");
        }
    }

}
