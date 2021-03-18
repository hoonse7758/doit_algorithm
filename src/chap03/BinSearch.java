package chap03;


import java.util.Scanner;

public class BinSearch {

    static int binSearch(int[] arr, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        System.out.print("   |");
        for (int i = 0 ; i < arr.length ; i++) {
            System.out.printf("%5d", i);
        }
        System.out.println();
        System.out.print("---+" + "-----".repeat(arr.length));

        int nofTrial = 0;
        int pc;
        do {
            pc = (pl + pr) / 2;

            System.out.println();
            System.out.print("   |");
            for (int e: arr) {
                if (e == pc) {
                    System.out.print("    *");
                } else if (e == arr[pl]) {
                    System.out.print("    <");
                } else if (e == arr[pr]) {
                    System.out.print("    >");
                } else {
                    System.out.print("     ");
                }
            }
            System.out.println();

            System.out.printf("%3d|", nofTrial);
            for (int e: arr) {
                System.out.printf("%5d", e);
            }
            System.out.println();
            System.out.println("---+" + "-----".repeat(arr.length));

            if (arr[pc] == key)
                return pc;
            else if (arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;

            nofTrial++;
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수 : "); int num = stdIn.nextInt();

        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : "); x[0] = stdIn.nextInt();
        for (int i = 1 ; i < x.length ; i++) {
            do {
                System.out.print("x[" + i + "] : "); x[i] = stdIn.nextInt();
            } while (x[i - 1] > x[i]);
        }

        System.out.print("검색할 값 : "); int key = stdIn.nextInt();

        int idx = binSearch(x, num, key);
        if (idx == -1) {
            System.out.println("\n그런 값은 없습니다.");
        } else {
            System.out.println("\nkey =" + key + " 는 x[" + idx + "] 에 있습니다.");
        }

    }

}
