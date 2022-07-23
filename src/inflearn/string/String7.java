package inflearn.string;

import java.util.Scanner;

/**
 * 회문 문자열 (앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열)
 * 문자열이 회문 문자열인지 체크.
 */
public class String7 {

    //StringBuilder reverse 메서드 활용.
    private static boolean solution1(String str) {
        String reverse = new StringBuilder(str).reverse().toString();
        return str.equals(reverse);
    }

    //직접 비교
    private static boolean solution2(String str) {
        int len = str.length();
        for (int i = 0; i < len/2; i++) {
            if (str.charAt(i) != str.charAt(len-i-1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution1(str));
        System.out.println(solution2(str));
    }
}
