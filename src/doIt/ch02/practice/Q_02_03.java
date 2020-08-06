package doIt.ch02.practice;

/**
 * 배열 a의 모든 요소의 합계를 구하여 반환하는 메서드를 작성.
 *
 * static int sumOf(int[] a)
 */
public class Q_02_03 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};

        System.out.println("합계 : " + sumOf(a));
    }

    static int sumOf(int[] a) {
        int sum = 0;

        for (int i = 0; i < a.length; i++)
            sum += a[i];

        return sum;
    }
}
