package doIt.ch05;

import doIt.ch04.IntStack;

import java.util.Scanner;

/**
 * 재귀 알고리즘의 비재귀적 표현
 */
public class Recur_05_05 {
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

    /**
     * 꼬리 재귀 제거 이후
     * n이 4인 경우 메서드 상단의 재귀 호출 recur(3)의 처리가 완료되지 않으면 n의 값인 '4'를 저장해야 한다.
     * 따라서 재귀 호출 recur(n - 1)을 아래처럼 바꾼다.
     *
     * 1. 현재 n의 값을 '잠시' 저장한다. (스택 사용)
     * 2. n의 값을 n - 1로 업데이트하고 메서드의 시작 지점으로 돌아간다.
     * 3. 저장했던 n을 다시 꺼내 그 값을 출력한다.
     *
     */
    static void recur3(int n) {
        IntStack stack = new IntStack(n);

        while (true) {
            if (n > 0) {
                stack.push(n);
                n = n - 1;
                continue;
            }
            if(!stack.isEmpty()) {
                n = stack.pop();
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur3(x);
    }
}
