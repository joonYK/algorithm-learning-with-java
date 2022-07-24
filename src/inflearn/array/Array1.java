package inflearn.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 큰 수 출력
 * N개의 정수를 입력받아 자신의 바로 앞 수보다 큰 수만 출력.
 *
 * 7 3 9 5 6 12 -> 7 9 6 12
 */
public class Array1 {

    private static List<Integer> solution(int n, int[] arr) {
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1])
                answer.add(arr[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        for (Integer integer : solution(n, arr)) {
            System.out.print(integer + " ");
        }
    }
}
