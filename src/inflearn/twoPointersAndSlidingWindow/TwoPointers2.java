package inflearn.twoPointersAndSlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 공통원소 구하기
 * A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성
 *
 * 첫 번째 줄에 집합 A의 크기 N(1<=N<=30,000)이 주어집니다.
 * 두 번째 줄에 N개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 세 번째 줄에 집합 B의 크기 M(1<=M<=30,000)이 주어집니다.
 * 네 번째 줄에 M개의 원소가 주어집니다. 원소가 중복되어 주어지지 않습니다.
 * 각 집합의 원소는 1,000,000,000이하의 자연수입니다.
 *
 * 입력 예시
 * 5
 * 1 3 9 5 2
 * 5
 * 3 2 5 7 8
 *
 * 출력 예시
 * 2 3 5
 */
public class TwoPointers2 {

    private static ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int p1 = 0, p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                answer.add(arr1[p1++]);
                p2++;
            } else if (arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("첫 번째 배열 개수 : ");
        int n = in.nextInt();
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("첫 번째 배열 " + i + "번지 : ");
            arr1[i] = in.nextInt();
        }

        System.out.print("두 번째 배열 개수 : ");
        int m = in.nextInt();
        int[] arr2 = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print("두 번째 배열 " + i + "번지 : ");
            arr2[i] = in.nextInt();
        }

        for (Integer i : solution(n, m, arr1, arr2)) {
            System.out.print(i + " ");
        }
    }
}
