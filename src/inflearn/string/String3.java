package inflearn.string;

import java.util.Scanner;

/**
 * 문장에서 가장 긴 단어 찾기
 * 각 단어는 공백으로 구분
 * 긴 단어가 여러개면 제일 첫 단어 출력
 */
public class String3 {

    //split 활용
    private static String solution1(String str) {
        String answer = "";
        int m = 0;
        String[] splitStr = str.split(" ");
        for (String s : splitStr) {
            int len = s.length();
            if (len > m) {
                m = len;
                answer = s;
            }
        }

        return answer;
    }

    //indexOf, substring 활용
    private static String solution2(String str) {
        String answer = "";
        int m = 0;
        int pos = 0;
        while ((pos = str.indexOf(" ")) != -1) {
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > m) {
                m = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }

        //마지막 단어 처리
        if (str.length() > m)
            answer = str;

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }
}
