package doIt.ch02.practice;

import java.util.Arrays;

/**
 * 배열 b의 모든 요소를 배열 a에 역순으로 복사하는 메서드 rcopy를 작성.
 *
 */
public class Q_02_05 {

    public static void main(String[] args) {
        int[] a = new int[10];
        int[] b = {33,1,41,5,57,27,11};

        rcopy(a, b);
        System.out.println(Arrays.toString(a));

        a = new int[10];
        rcopy2(a, b);
        System.out.println(Arrays.toString(a));
    }

    //답
    static void rcopy(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;

        for (int i = (b.length-1), j = 0; i >= (b.length - num); i--, j++)
            a[j] = b[i];
    }

    //답안지의 답
    static void rcopy2(int[] a, int[] b) {
        int num = a.length <= b.length ? a.length : b.length;
        for (int i = 0; i < num; i++)
            a[i] = b[b.length - i - 1];
    }
}
