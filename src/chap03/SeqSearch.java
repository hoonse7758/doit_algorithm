package chap03;


import java.util.Scanner;

public class SeqSearch {

    static int seqSearch(int[] arr, int n, int key) {

//        int i = 0;
//        while (true) {
//            if (i == n) {
//                return -1;
//            }
//            if (arr[i] == key) {
//                return i;
//            }
//            i++;
//        }

        for (int i = 0; i < arr.length ; i++) {
            if (arr[i] == key)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : "); int nofArr = stdIn.nextInt();
        int[] x = new int[nofArr];

        for (int i = 0 ; i < x.length ; i++) {
            System.out.print("x[" + i + "] = "); x[i] = stdIn.nextInt();
        }

        System.out.println("검색할 값 : "); int key = stdIn.nextInt();

        int idx = seqSearch(x, x.length, key);

        if (idx == -1) {
            System.out.println("그런 값은 없습니다.");
        } else {
            System.out.println(key + " 는 x[" + idx + "] 에 있습니다.");
        }
    }

}
