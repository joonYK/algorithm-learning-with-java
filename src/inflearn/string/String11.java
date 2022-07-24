package inflearn.string;

import java.util.Scanner;

/**
 * 문자열 압축
 * 알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에 반복 횟수 표기
 * ex) KKHSSSSSSSE -> K2HS7E
 */
public class String11 {

    private static String solution(String str) {
        str += " ";
        StringBuilder answer = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i+1)) {
                count++;
            } else {
                answer.append(str.charAt(i));
                if (count > 1)
                    answer.append(count);
                count = 1;
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }
}
