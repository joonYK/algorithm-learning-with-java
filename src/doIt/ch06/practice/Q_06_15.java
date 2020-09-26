package doIt.ch06.practice;

import doIt.ch04.IntStack;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 퀵 정렬 피벗 선택 개선 2.
 * 나눌 배열의 처음, 가운데, 끝 요소를 정렬한 다음 가운데 요소와 끝에서 두 번째 요소를 교환.
 * 피벗으로 끝에서 두 번째 요소의 값(a[right - 1])을 선택하여 나눌 대상의 범위를 a[left + 1] ~ a[right - 2]로 좁힌다.
 */
public class Q_06_15 {

    static int pivot(int[] a, int left, int right) {
        //처음, 중간, 끝 3개 요소 정렬
        int center = (left + right) / 2;
        if (a[left] > a[center])
            swap(a, left, center);
        if (a[center] > a[right])
            swap(a, center, right);
        if (a[left] > a[center])
            swap(a, left, center);

        //중간과 끝에서 두번째 요소 swap
        swap(a, center, right - 1);

        //끝에서 두번째 요소 피벗으로 반환
        return a[right - 1];
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
            int x = pivot(a, left, right);   //피벗
            int pl = left + 1;  //왼쪽 커서
            int pr = right - 2; //오른쪽 커서

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
                int x = pivot(a, left, right);   //피벗
                int pl = left + 1;  //왼쪽 커서
                int pr = right - 2; //오른쪽 커서

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
