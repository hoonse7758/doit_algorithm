package chap02;

public class IntArray {
    public static void main(String[] args) {
        int[] a = new int[5];

        a[1] = 37;
        a[2] = 51;
        a[4] = 2 * a[1];

        for (int i = 0 ; i < a.length ; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
