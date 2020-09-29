package doIt.ch06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Arrays.sort 메서드를 사용하여 정렬(퀵 정렬)
 */
public class ArraysSortTester_06_13 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++)
            x[i] = (int)(Math.random() * num) + 1;

        System.out.println("정렬 전 : " + Arrays.toString(x));

        Arrays.sort(x);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));
    }
}
