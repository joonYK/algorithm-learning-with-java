package inflearn.string;

import java.util.Scanner;

/**
 * 특정 문자 뒤집기
 * 알파벳과 특수문자로 구성된 문자열에서 알파벳만 뒤집음.
 */
public class String5 {

    private static String solution(String str) {
        char[] chars = str.toCharArray();
        int lt = 0;
        int rt = str.length() - 1;

        while(lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if(!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        System.out.println(solution(str));
    }
}
