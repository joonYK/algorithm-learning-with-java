package inflearn.array;

import java.util.Scanner;

/**
 * 가위 바위 보
 * A, B 두 사람이 가위바위보 게임을 합니다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고, B가 이기면 B를 출력합니다. 비길 경우에는 D를 출력합니다.
 * 1:가위, 2:바위, 3:보
 *
 * 입력
 * 5
 * 2 3 3 1 3
 * 1 1 2 2 3
 *
 * 출력
 * A
 * B
 * A
 * B
 * D
 */
public class Array3 {

    private static String solution(int n, int[] a, int[] b) {
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i]) {
                answer.append("D");
            } else if (a[i] == 1 && b[i] == 3) {
                answer.append("A");
            } else if (a[i] == 2 && b[i] == 1) {
                answer.append("A");
            } else if (a[i] == 3 && b[i] == 2) {
                answer.append("A");
            } else {
                answer.append("B");
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        System.out.println("A 입력");
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }

        System.out.println("B 입력");
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        for (char c : solution(n, a, b).toCharArray()) {
            System.out.println(c);
        }
    }
}
