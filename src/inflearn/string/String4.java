package inflearn.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 단어 뒤집기
 *
 * 첫 입력에 자연수 N(3<=N<=20)
 * 두 번째 입력부터 N개의 단어 입력
 */
public class String4 {

    //StringBuilder reverse 활용
    private static List<String> solution1(int n, String[] str) {
        List<String> answer = new ArrayList<>(n);

        for (String s : str) {
            String tmp = new StringBuilder(s).reverse().toString();
            answer.add(tmp);
        }

        return answer;
    }

    //직접 뒤집기
    private static List<String> solution2(int n, String[] str) {
        List<String> answer = new ArrayList<>(n);

        for (String s : str) {
            char[] chars = s.toCharArray();
            int lt = 0;
            int rt = s.length() - 1;

            while (lt < rt) {
                char tmp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = tmp;
                lt++;
                rt--;
            }

            answer.add(String.valueOf(chars));
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] str = new String[n];

        for (int i = 0; i < n; i++) {
            str[i] = in.next();
        }

        for (String s : solution1(n, str)) {
            System.out.println(s);
        }

        System.out.println();


        for (String s : solution2(n, str)) {
            System.out.println(s);
        }
    }
}
