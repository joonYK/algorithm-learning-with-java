package inflearn.string;

import java.util.Scanner;

/**
 * 가장 짧은 문자거리
 * 한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력.
 * 문자열 "teachermode" 문자 "e" -> 1 0 1 2 1 0 1 2 2 1 0
 */
public class String10 {

    private static int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        int distance = 1000;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == t) {
                distance = 0;
                answer[i] = distance;
            } else {
                answer[i] = ++distance;
            }
        }

        distance = 1000;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == t) {
                distance = 0;
                answer[i] = distance;
            } else {
                distance++;
                if (distance < answer[i])
                    answer[i] = distance;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        char t = in.next().charAt(0);
        for (int i : solution(s, t)) {
            System.out.print(i + " ");
        }
    }
}
