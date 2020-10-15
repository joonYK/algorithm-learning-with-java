package doIt.ch08.practice;

import java.util.Scanner;

/**
 * 브루트-포스법으로 검색 시 문자 패턴이 여러개일 때, 가장 뒤쪽의 인덱스를 반환하는 메서드를 작성.
 *
 * static int bfMatchLast(String txt, String pat)
 */
public class Q_08_02 {
    
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

    //브루트-포스법으로 문자열을 검색하는 메서드
    static int bfMatchLast(String txt, String pattern) {
        //txt 커서
        int pt = txt.length() - pattern.length();
        //pattern 커서
        int pp = 0;

        while (pt >= 0 && pp != pattern.length()) {
            if (txt.charAt(pt) == pattern.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp - 1;
                pp = 0;
            }
        }

        //검색 성공
        if (pp == pattern.length())
            return pt - pp;

        //검색 실패
        return -1;
    }

    //답안지 답
    /*static int bfMatchLast(String txt, String pat) {
        int pt = txt.length() - 1; // txt를 따라가는 커서
        int pp = pat.length() - 1; // pat를 따라가는 커서

        while (pt >= 0 && pp >= 0) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt--;
                pp--;
            } else {
                pt = pt + (pat.length() - pp) - 2;
                pp = pat.length() - 1;
            }
        }
        if (pp < 0) // 검색성공
            return pt + 1;
        return -1; // 검색실패
    }*/

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("텍스트 : ");
        String s1 = stdIn.next();

        System.out.print("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatchLast(s1, s2);

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
            System.out.printf(String.format("  패턴 : %%%ds\n", len), s2);
        }
    }
}
