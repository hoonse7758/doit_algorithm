package chap01;

public class Max3m {

    static int max3(int a, int b, int c) {
        int max = a;

        if (b > max) max = b;
        if (c > max) max = c;

        return max;
    }

    static int min3(int a1, int a2, int a3) {
        int min;

        min = a1;
        if (a2 < min) min = a2;
        if (a3 < min) min = a3;

        return min;
    }

    static int max4(int a1, int a2, int a3, int a4) {
        int max;

        max = a1;
        if (a2 > max) max = a2;
        if (a3 > max) max = a3;
        if (a4 > max) max = a4;

        return max;
    }

    static int min4(int a1, int a2, int a3, int a4) {
        int min;

        min = a1;
        if (a2 < min) min = a2;
        if (a3 < min) min = a3;
        if (a4 < min) min = a4;

        return min;
    }

    public static void main(String[] args) {
        System.out.println("max3(3, 2, 1) = "  + max3(3, 2, 1));
        System.out.println("max3(3, 2, 2) = "  + max3(3, 2, 2));
        System.out.println("max3(3, 1, 2) = "  + max3(3, 1, 2));
        System.out.println("max3(3, 2, 3) = "  + max3(3, 2, 3));
        System.out.println("max3(2, 1, 3) = "  + max3(2, 1, 3));
        System.out.println("max3(3, 3, 2) = "  + max3(3, 3, 2));
        System.out.println("max3(3, 3, 3) = "  + max3(3, 3, 3));
        System.out.println("max3(2, 2, 3) = "  + max3(2, 2, 3));
        System.out.println("max3(2, 3, 1) = "  + max3(2, 3, 1));
        System.out.println("max3(2, 3, 2) = "  + max3(2, 3, 2));
        System.out.println("max3(1, 3, 2) = "  + max3(1, 3, 2));
        System.out.println("max3(2, 3, 3) = "  + max3(2, 3, 3));
        System.out.println("max3(1, 2, 3) = "  + max3(1, 2, 3));

        System.out.println();

        System.out.println("min3(1,4,-2) = " + min3(1,4,-2));
        System.out.println("min4(-55, 0, 1, 99) = " + min4(-55, 0, 1, 99));
        System.out.println("max4(-55, 0, 1, 99) = " + max4(-55, 0, 1, 99));

    }
}
