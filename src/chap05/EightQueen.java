package chap05;


public class EightQueen {

    static boolean[] flag_rows = new boolean[8];
    static boolean[] flag_diag_l = new boolean[15];
    static boolean[] flag_diag_r = new boolean[15];
    static int[] pos = new int[8];

    static void print() {
        for (int i = 0 ; i < 8 ; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
        for (int j = 0 ; j < 8 ; j++) {
            for (int i = 0 ; i < 8 ; i++) {
                System.out.print((pos[i] == j) ? " ■": " □");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0 ; j < 8 ; j++) {
            if (!flag_rows[j] && !flag_diag_l[i + j] && !flag_diag_r[(i - j) + 7]) {
                pos[i] = j;
                if (i == 7) {
                    print();
                } else {
                    flag_rows[j] = flag_diag_l[i + j] = flag_diag_r[(i - j) + 7] = true;
                    set(i + 1);
                    flag_rows[j] = flag_diag_l[i + j] = flag_diag_r[(i - j) + 7] = false;
                }
            }
        }
    }

    static void setNoRecur(int i) {

    }

    public static void main(String[] args) {
        set(0);
    }
}
