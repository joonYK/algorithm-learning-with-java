package inflearn.string;

import java.util.Scanner;

/**
 * 숫자만 추출
 * 문자와 숫자가 섞여있는 문자열에서 숫자만 추출해서 자연수로 만듦.
 * "tge0a1h205er" -> 1205
 */
public class String9 {

    private static int solution1(String str) {
        StringBuilder answer = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c))
                answer.append(c);
        }
        return Integer.parseInt(answer.toString());
    }

    private static int solution2(String str) {
        int answer = 0;
        for (char c : str.toCharArray()) {
            //문자 0 ~ 9 는 아스키 코드로 48 ~ 57
            if (c >= 48 && c <= 57)
                answer = answer * 10 + (c - 48);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }
}
