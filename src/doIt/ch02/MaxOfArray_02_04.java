package doIt.ch02;

import java.util.Scanner;

public class MaxOfArray_02_04 {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if(a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("키의 최댓값을 구합니다.");
        System.out.print("사람 수 : ");
        int num = scanner.nextInt();

        int[] height = new int[num];

        for (int i = 0; i < height.length; i++) {
            System.out.print("height[" + i + "] : ");
            height[i] = scanner.nextInt();
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}
