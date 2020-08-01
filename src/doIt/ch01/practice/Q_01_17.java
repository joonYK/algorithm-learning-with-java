package doIt.ch01.practice;

/**
 * 아래와 같이 아래를 향한 n단의 숫자 피라미드를 출력
 * ※ i행에 출력하는 숫자는 i % 10으로 구하시오.
 *
 *        1
 *       222
 *      33333
 *     4444444
 */
public class Q_01_17 {
    public static void main(String[] args) {
        npira(5);
        System.out.println();
        System.out.println();

        npira2(5);
    }

    //작성한 답
    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i-1)*2+1; j++) {
                System.out.print(i % 10);
            }
            System.out.println();
        }
    }

    //답안지 답
    static void npira2(int n) {
        for (int i = 1; i <= n; i++) { 					// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= n - i + 1; j++) 		// n-i+1개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) 	// (i-1)*2+1개의 '*'를 나타냄
                System.out.print(i % 10);
            System.out.println(); 						// 개행(줄변환)
        }
    }

}
