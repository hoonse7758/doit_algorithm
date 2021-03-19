package chap03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhysExamSearch {

    static class PhyscData {
        private String  name;
        private int     height;
        private double  vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return this.name + "/" + this.height + "/" + this.vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return -Integer.compare(o1.height, o2.height);
            }
        }
    }

    private static void swap(PhyscData[] arr, int idx1, int idx2) {

        System.out.println("arr[" + idx1 + "] 와 arr[" + idx2 + "] 를 교환합니다.");

        PhyscData t = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = t;
    }

    static void reverse(PhyscData[] arr) {
        for (int i = 0 ; i < arr.length / 2 ; i++) {
            swap(arr, i, arr.length - (i + 1));
        }
        System.out.println("역순 정렬을 마쳤습니다.");
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("김한결", 169, 0.8),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("이수민", 175, 2.0)
        };
        PhyscData[] xReversed = x.clone() ; reverse(xReversed);

        System.out.print("몇 cm 인 사람을 찾고 있나요 ? : "); int height = stdIn.nextInt();

        int idx = Arrays.binarySearch(xReversed, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);

        if (idx < 0) {
            System.out.println("그런 요소는 없습니다.");
        } else {
            System.out.println("xReversed[" + idx + "] 에 있습니다.");
            System.out.println("찾은 데이터 : " + xReversed[idx]);
        }
    }

}
