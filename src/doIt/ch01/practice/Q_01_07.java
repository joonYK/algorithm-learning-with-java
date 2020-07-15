package doIt.ch01.practice;

import java.util.Scanner;

/**
 * SumFor 클래스를 참고해서 n 이 7이면 '1 + 2 + 3 + 4 + 5 + 6 + 7 = 28로 출력하는 프로그램
 */
public class Q_01_07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 입력하세요 : ");
        System.out.print("n의 값 : ");
        int n = scanner.nextInt();

        int sum = 0;

        for (int i = 1; i <= n; i++) {
            if(sum == 0)
                System.out.print(i);
            else
                System.out.print(" + " + i);
            sum += i;
        }

        System.out.print(" = " + sum);

    }

}
