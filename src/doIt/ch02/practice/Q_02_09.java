package doIt.ch02.practice;

import java.util.Scanner;

/**
 * y년 m월 d일의 그 해 남은 일 수(12월 31일이면 0, 12월 30일이면 1)를 구하는 아래 메서드를 작성.
 *
 * static int leftDayOfYear(int y, int m, int d)
 */
public class Q_02_09 {

    //각 달의 일수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //윤년
    };

    //윤년인지 확인 (1 : 윤년)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    // 서기 y년 m월 d일의 그 해 남은 일 수를 구함
    static int leftDayOfYear(int y, int m, int d) {
        int days = mdays[isLeap(y)][m-1] - d;

        while (++m <= 12)
            days += mdays[isLeap(y)][m-1];

        return days;
    }

    // 답안지의 답
    /*static int leftDayOfYear(int y, int m, int d) {
        int days = d; // 일수

        for (int i = 1; i < m; i++) // 1월~(m-1)월의 일 수를 더함
            days += mdays[isLeap(y)][i - 1];
        return 365 + isLeap(y) - days;
    }*/

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int retry;

        System.out.println("그 해 남은 일수를 구합니다.");

        do {
            System.out.print("년 : "); int year = stdIn.nextInt();
            System.out.print("월 : "); int month = stdIn.nextInt();
            System.out.print("일 : "); int day = stdIn.nextInt();

            System.out.printf("%d일 남았습니다.\n", leftDayOfYear(year, month, day));

            System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
            retry = stdIn.nextInt();
        } while (retry == 1);
    }
}
