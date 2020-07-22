package doIt.ch01.practice;

import java.util.Scanner;

/**
 * 아래와 같이 두 변수 a,b에 정수를 입력하고 b - a를 출력하는 프로그램을 작성.
 * ※ 단, 변수 b에 입력한 값이 a 이하면 변수 b의 값을 다시 입력하세요.
 *
 *
 * a의 값 : 6
 * b의 값 : 6
 * a보다 큰 값을 입력하세요!
 * b의 값 : 8
 * b - a는 2입니다.
 */
public class Q_01_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("b-a의 값을 구합니다.");

        System.out.print("a의 값 : ");
        int a = scanner.nextInt();

        //내가 작성한 답안
        /*System.out.print("b의 값 : ");
        int b = scanner.nextInt();

        while(b <= a) {
            System.out.println("a보다 큰 값을 입력하세요! ");
            System.out.print("b의 값 : ");
            b = scanner.nextInt();
        }*/

        //답안지
        int b=0;
        while(true) {
            System.out.print("b의 값 : ");
            b = scanner.nextInt();
            if(b > a)
                break;
            System.out.println("a보다 큰 값을 입력하세요!");
        }

        System.out.printf("b - a는 %d입니다.", b-a);
    }
}
