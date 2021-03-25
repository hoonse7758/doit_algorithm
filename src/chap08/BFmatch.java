package chap08;


import java.util.Scanner;

public class BFmatch {

    static String nSpace(int count) {
        return " ".repeat(count);
    }

    static int bfMatch(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        int loc = 0;
        int cnt = 0;

        while (pt != text.length() && pp != pattern.length()) {
            System.out.println(text);
            if (text.charAt(pt) == pattern.charAt(pp)) {
                System.out.println(nSpace(pt) + "+");
                System.out.println(nSpace(loc) + pattern);
                pt++;
                pp++;
            } else {
                System.out.println(nSpace(pt) + "|");
                System.out.println(nSpace(loc) + pattern);
                loc++;
                pt = pt - pp + 1;
                pp = 0;
            }
            System.out.println();
        }

        System.out.println("총 " + (loc + 1) + " 회 비교하였습니다.");

        if (pp == pattern.length()) {
            return pt - pp;
        }

        return -1;
    }

    static int bfMatchLast(String text, String pattern) {
        int pt = 0;
        int pp = 0;
        int loc = 0;
        int cnt = 0;

        while (pt != text.length() && pp != pattern.length()) {
            System.out.println(text);
            if (text.charAt(pt) == pattern.charAt(pp)) {
                System.out.println(nSpace(pt) + "+");
                System.out.println(nSpace(loc) + pattern);
                pt++;
                pp++;
            } else {
                System.out.println(nSpace(pt) + "|");
                System.out.println(nSpace(loc) + pattern);
                loc++;
                pt = pt - pp + 1;
                pp = 0;
            }
            System.out.println();
        }

        System.out.println("총 " + (loc + 1) + " 회 비교하였습니다.");

        if (pp == pattern.length()) {
            return pt;
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : "); String text = stdIn.next();
        System.out.print("패턴 : "); String pattern = stdIn.next();

        int idx = bfMatchLast(text, pattern);
        if (idx < 0) {
            System.out.println("텍스트 \"" + text + "\" 내에 패턴 \"" + pattern + "\" 가 검색되지 않습니다.");
        } else {
            int len = 0;
            for (int i = 0 ; i < idx ; i++) {
                len += text.substring(i, i + 1).getBytes().length;
            }
            len += pattern.length();

            System.out.println(idx + " 번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + text);
            System.out.println("패턴 : " + pattern);
        }

    }

}
