package doIt.ch01.practice;

import java.util.Scanner;

/**
 * 정수 a,b를 포함하여 그 사이의 모든 정수의 합을 구하여 반환하는 아래의 메서드 작성.
 * static int sumof(int a, int b)
 * ex) a=3, b=5 -> 3+4+5=12
 */
public class Q_01_09 {
    static int sumof(int a, int b) {
        if(a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        int sum = 0;

        for(int i = a; i <= b; i++)
            sum += i;

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("a부터 b까지의 정수 합을 구합니다.");
        System.out.print("a의 값 : ");
        int a = scanner.nextInt();
        System.out.print("b의 값 : ");
        int b = scanner.nextInt();

        System.out.println("a부터 b까지 정수 합은 " + sumof(a,b) + "입니다.");
    }
}
