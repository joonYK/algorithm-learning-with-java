package doIt.ch01;

import java.util.Scanner;

/**
 * 1부터 n까지의 합을 구하는데, n의 값으로 0이하의 값을 입력하면 다시 n의 값을 입력하도록 유도하는 알고리즘
 */
public class SumForPos_01_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.print("n의 값 : ");
            n = scanner.nextInt();
        } while (n <= 0);

        int sum = 0;

        for (int i = 0; i <= n; i++)
            sum += i;

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
