package doIt.ch01;

import java.util.Scanner;

/**
 * 입력한 값을 2자리의 양수로 제한
 */
public class Digits_1C_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int no;

        System.out.println("2자리의 정수를 입력하세요.");

        //"계속 조건"이 성립할 때 반복
        /*do {
            System.out.print("입력 : ");
            no = scanner.nextInt();
        } while (no < 10 || no > 100);*/

        //"종료 조건"이 성립할 때 반복
        do {
            System.out.print("입력 : ");
            no = scanner.nextInt();
        } while (!(no >= 10 && no <= 100));

        /**
         * 드모르간의 법칙
         * x && y  =  !(!x || !y)
         * x || y  =  !(!x && !y)
         */

        System.out.printf("변수 no의 값은 %d가(이) 되었습니다.", no);

    }
}
