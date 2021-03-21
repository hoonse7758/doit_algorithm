package chap05;


public class QueenB {

    static int[] pos = new int[8];

    static void print() {
        for (int po : pos) {
            System.out.printf("%2d", po);
        }
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0 ; j < 8 ; j++) {
            pos[i] = j;
            if (i == 7) {
                print();
            } else {
                set(i + 1);
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }

}
