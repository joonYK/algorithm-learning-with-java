package inflearn.string;

import java.util.Scanner;

/**
 * 문자열 찾기
 * 특정 문자열에 특정 문자가 몇 개 있는지 찾기 (대소문자 구분 없음)
 */
public class String1 {

    private static int solution(String str, char c) {
        int count = 0;
        String upperCaseStr = str.toUpperCase();
        char upperCaseCharacter = Character.toUpperCase(c);

        for (char c1 : upperCaseStr.toCharArray()) {
            if (c1 == upperCaseCharacter)
                count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        char c = in.next().charAt(0);
        System.out.println(solution(str, c));

    }
}
