package inflearn.twoPointers;

import java.util.Scanner;

/**
 * 연속된 자연수의 합
 *
 * N입력으로 양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는 방법의 가짓수를 출력하는 프로그램을 작성하세요.
 * 만약 N=15이면
 * 7+8=15
 * 4+5+6=15
 * 1+2+3+4+5=15
 * 총 3가지
 *
 */
public class TwoPointers4 {

    private static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = n / 2 + 1;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = i + 1;
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];

            if (sum == n)
                answer++;

            while (sum >= n) {
                sum -= arr[lt++];
                if (sum == n)
                    answer++;
            }
        }

        return answer;
    }

    private static int solution2(int n) {
        int answer = 0, cnt = 1;
        n--;

        while (n > 0) {
            cnt++;
            n -= cnt;

            /*
             * 처음 n이 15일 경우
             * cnt = 2, n = 12 라는 것은 1 + 2 + n = 15
             * n / cnt = 6
             * (1 + n / cnt) + (2 + n / cnt) = 15
             *
             * 따라서 n % cnt == 0 이 조건을 성립.
             */
            if (n % cnt == 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("N : ");
        int n = in.nextInt();
        System.out.println(solution(n));
        System.out.println(solution2(n));
    }
}
