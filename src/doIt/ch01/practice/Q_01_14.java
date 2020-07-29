package doIt.ch01.practice;

import java.util.Scanner;

/**
 * 아래와 같이 입력한 수를 한 변으로 하는 정사각형을 * 기호로 출력
 *
 * 단 수 : 3
 * ***
 * ***
 * ***
 */
public class Q_01_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("사각형을 출력합니다.");
        System.out.print("단 수 : ");
        int n = scanner.nextInt();

        //내가 작성한 답
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
