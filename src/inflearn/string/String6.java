package inflearn.string;

import java.util.Scanner;

/**
 * 중복문자 제거
 */
public class String6 {

    private static String solution(String str) {
        String answer = "";

        for (int i = 0; i < str.length(); i++) {
            //i와 해당 문자의 str내 index 위치가 다르면 중복문자 (indexOf의 위치는 제일 첫 문자의 위치를 나타냄)
            if (str.indexOf(str.charAt(i)) == i)
                answer += str.charAt(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }
}
