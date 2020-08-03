package doIt.ch02.practice;

import java.util.Random;

/**
 * 키뿐만 아니라 사람 수도 난수로 생성하도록 실습 2-5 (MaxOfArrayRand_02_05) 를 수정하여 프로그램을 작성.
 */
public class Q_02_01 {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max)
                max = a[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        System.out.println("키의 최댓값을 구합니다.");
        int[] height = new int[1 + rand.nextInt(10)];

        //답안지 답안
        /*int num = 1 + rand.nextInt(20);      // 사람 수를 1~20의 난수로 생성하는
        int[] height = new int[num];         // 요솟수 num인 배열을 생성*/

        System.out.println("사람 수 : " + height.length);

        System.out.println("키 값은 아래와 같습니다.");
        for (int i = 0; i < height.length; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "] : " + height[i]);
        }

        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}
