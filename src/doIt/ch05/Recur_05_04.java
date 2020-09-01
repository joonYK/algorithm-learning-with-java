package doIt.ch05;

import java.util.Scanner;

/**
 * 재귀 알고리즘의 비재귀적 표현
 */
public class Recur_05_04 {

    //재귀 함수
    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    /**
     * 꼬리 재귀의 제거
     * 메서드의 꼬리에서 재귀 호출하는 recur(n - 2)라는 말은 '인자로 n - 2를 전달하여 recur 메서드를 호출한다는 의미.
     *
     * "n의 값을 n - 2로 업데이트하고 메서드의 시작 지점으로 돌아간다."
     */
    static void recur2(int n) {
        while (n > 0) {
            recur (n - 1);
            System.out.println(n);
            n = n - 2;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur2(x);
    }
}
