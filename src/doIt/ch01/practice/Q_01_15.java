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

}
