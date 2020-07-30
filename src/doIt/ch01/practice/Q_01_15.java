package doIt.ch01.practice;

/**
 * 직각 이등변 삼각형을 출력하는 부분을 아래와 같은 형식의 메서드로 작성.
 *
 * static void triangleLB(int n) //왼쪽 아래가 직각인 이등변 삼각형을 출력
 * static void triangleLU(int n) //왼쪽 위가 직각인 이등변 삼각형을 출력
 * static void triangleRU(int n) //오른쪽 위가 직각인 이등변 삼각형을 출력
 * static void triangleRB(int n) //오른쪽 아래가 직각인 이등변 삼각형을 출력
 */
public class Q_01_15 {
    public static void main(String[] args) {
        System.out.println("1.왼쪽 아래가 직각인 이등변 삼각형.");
        triangleLB(5);

        System.out.println("\n2.왼쪽 위가 직각인 이등변 삼각형.");
        triangleLU(5);

        System.out.println("\n3.오른쪽 위가 직각인 이등변 삼각형.");
        triangleRU(5);

        System.out.println("\n4.오른쪽 아래가 직각인 이등변 삼각형.");
        triangleRB(5);

    }

    static void triangleLB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n-i; j > 0; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(j >= i ? "*" : " ");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(j >= (n-1)-i ? "*" : " ");
            }
            System.out.println();
        }
    }

    //------------------- 아래는 답안지의 답안 ---------------------------------

    /*// 왼쪽 아래가 직각인 이등변삼각형을 출력
    static void triangleLB(int n) {
        for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= i; j++) 			// i개의 '*'를 나타냄
                System.out.print('*');
            System.out.println(); 					// 개행(줄변환)
        }
    }

    // 왼쪽 위가 직각인 이등변삼각형을 출력
    static void triangleLU(int n) {
        for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= n - i + 1; j++) 	// n-i+1개의 '*'를 나타냄
                System.out.print('*');
            System.out.println(); 					// 개행(줄변환)
        }
    }

    // 오른쪽 위가 직각인 이등변삼각형을 출력
    static void triangleRU(int n) {
        for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,n)
            for (int j = 1; j <= i - 1; j++) 		// i-1개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= n - i + 1; j++) 	// n-i+1개의 '*'를 나타냄
                System.out.print('*');
            System.out.println();					// 개행(줄변환)
        }
    }

    // 오른쪽 아래가 직각인 이등변삼각형을 출력
    static void triangleRB(int n) {
        for (int i = 1; i <= n; i++) { 				// i행 (i = 1, 2, … ,ln)
            for (int j = 1; j <= n - i; j++) 		// n-i개의 ' '를 나타냄
                System.out.print(' ');
            for (int j = 1; j <= i; j++) 			// i개의 '*'를 나타냄
                System.out.print('*');
            System.out.println(); 					// 개행(줄변환)
        }
    }*/
}
