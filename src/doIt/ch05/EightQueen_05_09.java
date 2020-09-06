package doIt.ch05;

/**
 * 최종 8퀸 문제 풀이
 * 대각선 방향으로도 겹치지 않도록.
 */
public class EightQueen_05_09 {
    static boolean[] flag_a = new boolean[8];   //객 헹에 퀸을 배치했는지 체크
    static boolean[] flag_b = new boolean[15];  // 오른쪽 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] flag_c = new boolean[15];  // 왼쪽 대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos = new int[8];  //각 열의 퀸의 위치

    //각 열의 퀸의 위치를 출력
    static void print() {
        for (int i = 0; i < 8; i++)
            System.out.printf("%2d", pos[i]);
        System.out.println();
    }

    // i열의 알맞은 위치에 퀸을 배치
    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            if (flag_a[j] == false &&   //가로(j행)에 아직 배치하지 않음
                flag_b[i + j] == false &&   //오른쪽 대각선에 아직 배치하지 않음
                flag_c[i - j + 7] == false) {   //왼쪽 대각선에 아직 배치하지 않음
                pos[i] = j;
                if (i == 7)
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
