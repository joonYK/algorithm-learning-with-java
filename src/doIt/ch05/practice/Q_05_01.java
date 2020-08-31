package doIt.ch05.practice;

import java.util.Scanner;

/**
 * 재귀 메서드 호출을 사용하지 않고 실습 5_1의 factorial 메서드를 작성.
 */
public class Q_05_01 {
    static int factorial(int n) {
        int result = 1;
        for (int i = n; i > 1; i--)
            result *= i;

        return result;
    }

    //답안지의 답
    static int factorial2(int n) {
        int fact = 1;

        while (n > 1)
            fact *= n--;
        return (fact);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
