package chap01;


import java.util.Scanner;

public class Multi99Table {

    static void multi99Table() {
        System.out.println("곱셈표");

        // --
        System.out.print("    | ");
        for(int j = 1 ; j < 9 + 1 ; j++) {
            System.out.printf("%3d", 1 * j);
        }
        System.out.println();

        // --
        System.out.print("----+-");
        for(int j = 1 ; j < 9 + 1 ; j++) {
            System.out.print("---");
        }
        System.out.println();

        for(int i = 1 ; i < 9 + 1 ; i++) {
            System.out.printf("%3d | ", i);
            for(int j = 1 ; j < 9 + 1 ; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }

    static void sum99Table() {
        System.out.println("덧셈표");

        // --
        System.out.print("    | ");
        for(int j = 1 ; j < 9 + 1 ; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();

        // --
        System.out.print("----+-");
        for(int j = 1 ; j < 9 + 1 ; j++) {
            System.out.print("---");
        }
        System.out.println();

        for(int i = 1 ; i < 9 + 1 ; i++) {
            System.out.printf("%3d | ", i);
            for(int j = 1 ; j < 9 + 1 ; j++) {
                System.out.printf("%3d", i + j);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        multi99Table();
        sum99Table();

        Scanner stdIn = new Scanner(System.in);

        System.out.println("Q14");
        int width;
        do {
            System.out.print("width = "); width = stdIn.nextInt();
            if (width <= 0) {
                System.out.println("width 값은 양의 정수만 입력 가능합니다.");
            }
        } while (width <= 0);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < width; h++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
