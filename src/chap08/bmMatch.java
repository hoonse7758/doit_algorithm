package chap08;


import java.util.Scanner;

public class bmMatch {

    static int bmMatch(String text, String pattern) {
        int pt;
        int pp;
        int txtLen = text.length();
        int patLen = pattern.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        //
        for (pt = 0 ; pt <= Character.MAX_VALUE ; pt++) {
            skip[pt] = patLen;
        }
        for (pt = 0 ; pt < patLen - 1 ; pt++) {
            skip[pattern.charAt(pt)] = patLen - 1 - pt;
        }

        //
        while (pt < txtLen) {
            pp = patLen - 1;

            while (text.charAt(pt) == pattern.charAt(pp)) {
                if (pp == 0) {
                    return pt;
                }
                pp--;
                pt--;
            }
            pt += Math.max(skip[text.charAt(pt)], patLen - pp);
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : "); String text = stdIn.next();
        System.out.print("패턴 : "); String pattern = stdIn.next();

        int idx = bmMatch(text, pattern);
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
