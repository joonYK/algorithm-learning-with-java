package doIt.ch06;

import java.util.Scanner;

/**
 * 셸 정렬(버전 2)
 * 기존 버전 1은 h가 4, 2, 1로 2의 배수기 때문에 각 그룹별로만 서로 섞여서 효율적으로 정렬되지 않음.
 * h의 값을 배수가 되지 않게해서 요소가 충분히 잘 섞이게 개선한 버전.
 *
 * h의 값은 ... 40, 13, 4, 1 (3배 더하기 1)
 */
public class ShellSort2_06_07 {

    //셸 정렬
    static void shellSort(int[] a, int n) {
        int h;

        // h의 초깃값을 구한다. 1부터 시작하여 값을 3배하고 1을 더하면서 n/9를 넘지 않는 가장 큰 값을 h에 대입.
        for (h = 1; h < n / 9; h = h * 3 + 1)
            ;

        //h의 값을 계속 3으로 나눈다. 마지막엔 h의 값이 1이 된다.
        for (; h > 0; h /= 3) {
            for (int i = 0; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬(버전 2)");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        shellSort(x, nx);   //배열 x를 셸 정렬

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("X[" + i + "] = " + x[i]);
    }
}
