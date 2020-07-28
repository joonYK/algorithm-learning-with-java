package doIt.ch01.practice;

/**
 * Multi99Table_01_07의 곱셈표 위쪽, 왼쪽에 곱하는 수가 있는 곱셈표를 출력.
 *
 */
public class Q_01_12 {
    public static void main(String[] args) {

        //내가 작성한 답
        System.out.printf("%3s|", " ");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);

        System.out.print("\n---+");
        for (int i = 1; i <= 9; i++)
            System.out.print("---");

        for (int i = 1; i <= 9; i++) {
            System.out.printf("\n%2d |", i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
        }

        System.out.println();
        System.out.println();
        System.out.println();

        //답안지
        System.out.print("   |");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);
        System.out.println("\n---+---------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 9; j++)
                System.out.printf("%3d", i * j);
            System.out.println();
        }
    }
}
