package doIt.ch08;

import java.util.Scanner;

/**
 * 브루트-포스법으로 문자열 검색
 */
public class BFmatch_08_01 {
    
    //브루트-포스법으로 문자열을 검색하는 메서드
    static int bfMatch(String txt, String pattern) {
        //txt 커서
        int pt = 0;
        //pattern 커서
        int pp = 0;

        while (pt != txt.length() && pp != pattern.length()) {
            if (txt.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        //검색 성공
        if (pp == pattern.length())
            return pt - pp;

        //검색 실패
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            //일치하는 문자 바로 앞까지의 길이를 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
               len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
        }
    }
}
