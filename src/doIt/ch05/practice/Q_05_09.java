package doIt.ch05.practice;

/**
 * 8퀸 문제를 비재귀적으로 구현
 */
public class Q_05_09 {
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
        int[] colPos = new int[8];
        int j = 0;

        while(true) {
            while(j < 8) {
                if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
                    pos[i] = j;
                    if (i == 7) {
                        print();
                    } else {
                        flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                        colPos[i] = j;
                        j = 0;
                        i = i + 1;
                        continue;
                    }
                }
                j++;
            }

            if(i-- == 0)
                return;

            colPos[i+1] = 0;
            j = colPos[i];
            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
            j++;
        }
    }

    // 답안지의 답
    static void set2(int i) {
        int j;
        int[] jstk = new int[8];

        Start: while (true) {
            j = 0;
            while (true) {
                while (j < 8) {
                    if (!flag_a[j] && !flag_b[i + j] && !flag_c[i - j + 7]) {
                        pos[i] = j;
                        if (i == 7) // 모든 열에 배치 마침
                            print();
                        else {
                            flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                            jstk[i++] = j; // i 열의 행을 Push
                            continue Start;
                        }
                    }
                    j++;
                }
                if (--i == -1)
                    return;
                j = jstk[i]; // i 열의 행을 Pop
                flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
