package inflearn.string;

import java.util.Scanner;

/**
 * 대소문자 변환
 */
public class String2 {

    //Character 라이브러리 활용
    private static String solution1(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (Character.isLowerCase(c))
                sb.append(Character.toUpperCase(c));
            else
                sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }

    //아스키 코드 활용
    //대문자 A ~ Z = 65 ~ 90
    //소문자 a ~ z = 97 ~ 122
    private static String solution2(String str) {
        StringBuilder sb = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c >= 97 && c <= 122)
                sb.append((char)(c - 32));
            else
                sb.append((char)(c + 32));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }
}
