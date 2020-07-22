package doIt.ch01.practice;

import java.util.Scanner;

/**
 * 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성. 예를 들어 135를 입력하면,
 * '그 수는 3자리입니다.'라고 출력하고, 1314를 입력하면 '그 수는 4자리입니다.'라고 출력. (반복문 사용)
 */
public class Q_01_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("양의 정수를 입력하세요 : ");
        int n = scanner.nextInt();
        int count = 0;

        //내가 작성한 답안
        /*do {
            n /= 10;
            count++;
        } while (n != 0);*/

        //답안지
        while (n > 0) {
            n /= 10;
            count++;
        }

        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
