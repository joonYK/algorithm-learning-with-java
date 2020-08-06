package doIt.ch02.practice;

import java.util.Arrays;

/**
 * 배열 b의 모든 요소를 배열 a에 복사하는 메서드 copy를 작성.
 *
 * static void copy(int[] a, int[] b)
 */
public class Q_02_04 {
    public static void main(String[] args) {
        int[] b = {1,2,3,4,5};
        int[] a = new int[b.length];

        copy(a, b);

        System.out.println(Arrays.toString(a));
    }

    //답
    static void copy(int[] a, int[] b) {
        for (int i = 0; i < b.length; i++)
            a[i] = b[i];
    }

    //답안지의 답
    static void copy2(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++)
            a[i] = b[i];
    }
}
