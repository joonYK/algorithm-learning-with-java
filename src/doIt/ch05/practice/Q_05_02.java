package doIt.ch05.practice;

import java.util.Scanner;

/**
 * 재귀 메서드 호출을 사용하지 않고 실습 5-2의 gcd 메서드를 작성.
 */
public class Q_05_02 {
    static int gcd(int x, int y) {
        int temp = 0;

        while(y != 0) {
            temp = x % y;
            x = y;
            y = temp;
        }

        return x;
    }

    //답안지의 답
    static int gcd2(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return (x);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구합니다.");

        System.out.print("정수를 입력하세요 : ");
        int x = stdIn.nextInt();
        System.out.print("정수를 입력하세요 : ");
        int y = stdIn.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}
