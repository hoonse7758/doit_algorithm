package chap02;


import java.util.Scanner;

public class PhysicalExamination {

    static final int VMAX = 21;
    static final String BARCHAR = "*";

    static class PhysicsData {
        String name;
        int height;
        double vision;

        PhysicsData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }
    }

    static double avgHeight(PhysicsData[] arr) {
        double sum = 0;

        for (PhysicsData physicsData : arr) {
            sum += physicsData.height;
        }

        return sum/arr.length;
    }

    static void distVision(PhysicsData[] arr, int[] dist) {
        int i = 0;

        dist[i] = 0;
        for (i = 0 ; i < arr.length ; i++) {
            if (arr[i].vision >= 0.0 && arr[i].vision <= VMAX / 10.0) {
                dist[(int)(10 * arr[i].vision)]++;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhysicsData[] x = {
                new PhysicsData("박현규", 162, 0.3),
                new PhysicsData("함진아", 173, 0.7),
                new PhysicsData("최현미", 175, 2.0),
                new PhysicsData("홍연의", 171, 1.5),
                new PhysicsData("강춘래", 171, 1.5),
                new PhysicsData("이수진", 168, 0.4),
                new PhysicsData("김영준", 174, 1.2),
                new PhysicsData("박용규", 169, 0.8),
        };
        int[] vdist = new int[VMAX];
        char[] distBar = new char[VMAX];

        System.out.println("< 신체검사 리스트 >");
        System.out.println("이름      키   시력");
        System.out.println("-----------------");
        for (PhysicsData physicsData : x) {
            System.out.printf("%-8s%3d%5.1f\n", physicsData.name, physicsData.height, physicsData.vision);
        }
        System.out.printf("\n평균 키 : %5.1f cm", avgHeight(x));

        distVision(x, vdist);
        System.out.println("\n시력 분포");
        for (int i = 0 ; i < VMAX ; i++) {
            System.out.printf("%3.1f~:%s\n", i / 10.0, BARCHAR.repeat(vdist[i]));
        }

    }

}
