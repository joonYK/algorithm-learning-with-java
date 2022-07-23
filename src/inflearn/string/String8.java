package inflearn.string;

import java.util.Scanner;

/**
 * 팰린드롬 (앞에서 읽을 때나 뒤에서 읽을 떄나 같은 문자열)
 * 회문 검사시 알파벳만 가지고 회문을 검사, 대소문자 구분하지 않음.
 *
 * ex) found7, time: study; Yduts; emit, 7Dnuof
 */
public class String8 {

    private static boolean solution(String str) {
        str = str.toUpperCase().replaceAll("[^A-Z]", "");
        String reserve = new StringBuilder(str).reverse().toString();
        return str.equals(reserve);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        System.out.println(solution(str));
    }
}
