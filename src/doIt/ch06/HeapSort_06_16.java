package doIt.ch06;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 힙 정렬
 */
public class HeapSort_06_16 {
    //배열 요소 a[idx1]과 a[idx2]의 값을 바꿉니다.
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //a[left] ~ a[right]를 힙으로 만듭니다.
    static void downHeap(int[] a, int left, int right) {
        //루트
        int temp = a[left];
        //큰 값을 가진 노드
        int child;
        //부모
        int parent;

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            //왼쪽 자식
            int cl = parent * 2 + 1;
            //오른쪽 자식
            int cr = cl + 1;
            //큰 값을 가진 노드를 자식에 대입
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
            if (temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    //힙 정렬
    static void heapSort(int[] a, int n) {
        // a[i] ~ a[n-1]를 힙으로 만들기
        for (int i = (n - 1); i >= 0; i--)
            downHeap(a, i, n - 1);

        for (int i = n - 1; i > 0; i--) {
            //가장 큰 요소와 아직 정렬되지 않은 부분의 마지막 요소를 교환
            swap(a, 0, i);
            //a[0] ~ a[i-1]을 힙으로 만듦
            downHeap(a, 0, i - 1);
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for (int i = 0; i < num; i++)
            x[i] = (int)(Math.random() * num) + 1;

        System.out.println("정렬 전 : " + Arrays.toString(x));

        heapSort(x, num);

        System.out.println("오름차순으로 정렬했습니다.");
        System.out.println(Arrays.toString(x));
    }
}
