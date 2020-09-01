package doIt.ch05;

import java.util.Scanner;

/**
 * 재귀알고리즘 분석
 */
public class Recur_05_03 {

    /**
     * recur 메서드의 하향식 분석
     * recur(1), recur(2)의 호출이 여러번 발생하기하는 구조기 때문에
     * 메서드의 호출부터 아래로 내려가면서 분석하는 하향식 분석은 비효율적
     */

    /**
     * recur 메서드의 상향식 분석
     * n이 4일 때
     * recur(-1) : 아무것도 하지않음
     * recur(0) : 아무것도 하지 않음
     * recur(1) : recur(0) 1 recur(-1) => 1
     * recur(2) : recur(1) 2 recur(0)  => 1 2
     * recur(3) : recur(2) 3 recur(1)  => 1 2 3 1
     * recur(4) : recur(3) 4 recur(2)  => 1 2 3 1 4 1 2
     */

    //재귀 함수
    static void recur(int n) {
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        recur(x);
    }

}

