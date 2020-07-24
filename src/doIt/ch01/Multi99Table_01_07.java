package doIt.ch01;

/**
 * 이중 루프를 사용해서 곱셈표를 출력
 *
 */
public class Multi99Table_01_07 {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}
