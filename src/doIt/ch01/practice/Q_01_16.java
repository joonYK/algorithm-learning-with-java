package doIt.ch01.practice;

/**
 * n단의 피라미드를 출력하는 메서드를 작성 (아래는 4단의 예)
 * ※ i 행에는 (i-1) * 2 + 1개의 기호 문자 *가 출력 되게 하시오
 * ※ 마지막 n 행에는 (m-1) * 2 + 1개의 기호 문자 *를 출력.
 *
 *
 *        *
 *       ***
 *      *****
 *     *******
 */
public class Q_01_16 {
    public static void main(String[] args) {
        spira(5);
        System.out.println();
        System.out.println();
        spira2(5);
    }

    //작성한 답
    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i-1)*2+1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //답안지 답
    static void spira2(int n) {
        for (int i = 1; i <= n; i++) { 					// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= n - i + 1; j++) 		// n-i+1개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) 	// (i-1)*2+1개의 '*'를 나타냄
                System.out.print('*');
            System.out.println(); 						// 개행(줄변환)
        }
    }
}
