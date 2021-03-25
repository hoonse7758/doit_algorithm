package chap08;


import java.util.Scanner;

public class kmpMatch {

    static int kmpMatch(String text, String pattern) {
        int pt = 1;
        int pp = 0;
        int[] skip = new int[pattern.length() + 1];

        skip[pt] = 0;
        while (pt != pattern.length()) {
            if (pattern.charAt(pt) == pattern.charAt(pp)) {
                skip[++pt] = ++pp;
            } else if (pp == 0) {
                skip[++pt] = pp;
            } else {
                pp = skip[pp];
            }
        }

        pt = pp = 0;
        while (pt != text.length() && pp != pattern.length()) {
            if (text.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else if (pp == 0){
                pt++;
            } else {
                pp = skip[pp];
            }
        }

        if (pp == pattern.length()) {
            return pt - pp;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : "); String text = stdIn.next();
        System.out.print("패턴 : "); String pattern = stdIn.next();

        int idx = kmpMatch(text, pattern);
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
