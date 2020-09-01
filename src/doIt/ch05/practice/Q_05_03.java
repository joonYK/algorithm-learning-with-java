package doIt.ch05.practice;

import java.util.Scanner;

/**
 * 배열 a의 모든 요소의 최대공약수를 구하는 다음 메서드를 작성.
 *
 * static int gcdArray(int[] a)
 */
public class Q_05_03 {
    static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    static int gcdArray(int[] a) {
        if(a.length == 1)
            return a[0];

        int max = a[0];

        //배열중에 제일 큰 수를 구함.
        for (int i = 1; i < a.length; i++)
            if(max < a[i])
                max = a[i];

        int result = 0;
        for (int i : a) {
            //제일 큰 수와의 최대공약수를 구함.
            if (max != i) {
                int x = gcd(max, a[i]);
                
                //최대공약수가 제일 작은걸 반환하도록
                if (x == 1)
                    return 1;
                else if (result == 0 || result < x)
                    result = x;
            }
        }

        return result;
    }

    //답안지의 답
    static int gcdArray2(int a[], int start, int no) {
        if (no == 1)
            return a[start];
        else if (no == 2)
            return gcd(a[start], a[start + 1]);
        else
            return gcd(a[start], gcdArray2(a, start + 1, no - 1));
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열 모든 요소의 최대공약수를 구합니다.");
        System.out.print("배열 요솟수 입력 : ");
        int n = stdIn.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print(i + "번지 배열의 정수 입력 : ");
            a[i] = stdIn.nextInt();
        }

        System.out.println("최대공약수는 " + gcdArray(a) + "입니다.");
    }


}
