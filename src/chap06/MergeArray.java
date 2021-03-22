package chap06;


import java.util.Scanner;

public class MergeArray {

    static void merge(int[] arr1, int[] arr2, int[] arrTgt) {

        int n1 = arr1.length;
        int n2 = arr2.length;
        int nTgt = arrTgt.length;

        int p1 = 0;
        int p2 = 0;
        int pTgt = 0;

        while (p1 < n1 && p2 < n2) {
            arrTgt[pTgt++] = (arr1[p1] <= arr2[p2]) ? arr1[p1++]: arr2[p2++];
        }
        while (p1 < n1) {
            arrTgt[pTgt++] = arr1[p1++];
        }
        while (p2 < n2) {
            arrTgt[pTgt++] = arr2[p2++];
        }

    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        int[] arr1 = {2, 4, 6, 8, 11, 13};
        int[] arr2 = {1, 2, 3, 4, 9, 16, 21};
        int[] arrTgt = new int[arr1.length + arr2.length];

        System.out.println("두 배열의 병합");
        merge(arr1, arr2, arrTgt);

        System.out.println("배열 arr1 과 arr2 를 병합하여 배열 arrTgt 에 저장하였습니다.");

        System.out.print("배열 arr1 : ");
        for (int i = 0 ; i < arr1.length ; i++) {
            System.out.print("arr1[" + i + "] == " + arr1[i] + " / ");
        }
        System.out.println();

        System.out.print("배열 arr2 : ");
        for (int i = 0 ; i < arr2.length ; i++) {
            System.out.print("arr2[" + i + "] == " + arr2[i] + " / ");
        }
        System.out.println();

        System.out.print("배열 arrTgt : ");
        for (int i = 0 ; i < arrTgt.length ; i++) {
            System.out.print("arrTgt[" + i + "] == " + arrTgt[i] + " / ");
        }
        System.out.println();

    }

}
