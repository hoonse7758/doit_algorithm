package chap06;


import chap02.PhysicalExamination;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PhyscExamSort {

    static class PhyscData {
        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return this.name + " / " + this.height + " / " + this.vision;
        }

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.vision < o2.vision) ? 1 : (o1.vision > o2.vision) ? -1 : 0;
            }
        }

        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한결", 169, 0.8),
        };

        Arrays.sort(x, PhyscData.HEIGHT_ORDER);

        System.out.println("< 신체검사 리스트 >");
        System.out.println("이름      키   시력");
        System.out.println("-----------------");
        for (PhyscExamSort.PhyscData physicsData : x) {
            System.out.printf("%-8s%3d%5.1f\n", physicsData.name, physicsData.height, physicsData.vision);
        }

    }

}
