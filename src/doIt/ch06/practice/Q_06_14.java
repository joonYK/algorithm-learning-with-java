package doIt.ch06.practice;

import doIt.ch04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 나눌 배열의 요소 개수가 3개 이상이면 임의로 요소 3을 선택하고 그중에서 중앙값인 요소를
 * 피벗으로 선택해서 정렬하도록 Q_06_13을 수정.
  */
public class Q_06_14 {

    //3개의 값 중 중간 값을 구함
    static int middleNum(int a, int b, int c) {
        if (a >= b) {
            if (b >= c)
                return b;
            else if(a >= c)
                return c;
            else
                return a;
        } else if(a > c) {
            return a;
        } else if(b > c) {
            return c;
        } else {
            return b;
        }
    }

    //단순 선택 정렬
    static void insertSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int tmp = a[i];
            int j;
            for (j = i; j > left && a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

    // a[idx1]와 a[idx2]의 값을 바꾼다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //퀵 정렬
    static void quickSort(int[] a, int left, int right) {
        if(right - left <= 9)
            insertSort(a, left, right);
        else {
            int pl = left;  //왼쪽 커서
            int pr = right; //오른쪽 커서
            int x = middleNum(a[left], a[(left + right) / 2], a[right]);   //피벗

            do {
                while (a[pl] < x) pl++;
                while (a[pr] > x) pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);

            if (pr - left < right - pl) {
                int temp;
                temp = left;
                left = pl;
                pl = temp;
                temp = right;
                right = pr;
                pr = temp;
            }
            if (left < pr)
                quickSort(a, left, pr);
            if (pl < right)
                quickSort(a, pl, right);
        }
    }


    static void quickSortNoRecur(int[] a, int left, int right) {
        IntStack lstack = new IntStack(right - left + 1);
        IntStack rstack = new IntStack(right - left + 1);

        lstack.push(left);
        rstack.push(right);

        while (!lstack.isEmpty()) {
            left = lstack.pop();
            right = rstack.pop();

            if(right - left <= 9)
                insertSort(a, left, right);
            else {
                int pl = left;   //왼쪽 커서
                int pr = right;  //오른쪽 커서
                int x = middleNum(a[left], a[(left + right) / 2], a[right]);   //피벗

                do {
                    while (a[pl] < x) pl++;
                    while (a[pr] > x) pr--;
                    if (pl <= pr)
                        swap(a, pl++, pr--);
                } while (pl <= pr);

                if (pr - left < right - pl) {
                    int temp;
                    temp = left;
                    left = pl;
                    pl = temp;
                    temp = right;
                    right = pr;
                    pr = temp;
                }
                if (left < pr) {
                    lstack.push(left);
                    rstack.push(pr);
                }
                if (pl < right) {
                    lstack.push(pl);
                    rstack.push(right);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];
        int[] a = new int[nx];

        for (int i = 0; i < nx; i++)
            x[i] = a[i] = (int) (Math.random() * nx) + 1;

        System.out.println("정렬 전");
        System.out.println("x : " + Arrays.toString(x));
        System.out.println("a : " + Arrays.toString(a));

        quickSort(x, 0, nx - 1);
        quickSortNoRecur(a, 0, nx - 1);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println("x : " + Arrays.toString(x));
        System.out.println("a : " + Arrays.toString(a));

    }
}
