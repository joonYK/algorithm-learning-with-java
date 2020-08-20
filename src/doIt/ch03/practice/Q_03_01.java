package doIt.ch03.practice;

import java.util.Scanner;

/**
 * 실습 3-3의 seqSearchSen 메서드를 while문이 아니라 for문을 사용하여 수정한 프로그램을 작성.
 */
public class Q_03_01 {

    //요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색
    static int seqSearch(int[] a, int n, int key) {
        a[n] = key; //보초를 추가

        int i = 0;
        for (; i < n; i++) {
            if (a[i] == key)
                break;
        }

        //답안지 답
        //for (i = 0; a[i] != key; i++) ;

        return i == n ? -1 : i; //i값이 n이면 찾은 값이 보초이므로 검색 실패.
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1];     //요솟수 num + 1

        for (int i = 0; i < num; i++) {
            System.out.print("X[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("검색할 값 : ");
        int ky = stdIn.nextInt();

        int idx = seqSearch(x, num, ky);    //배열 x에서 키 값이 ky인 요소를 검색

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) X[" + idx + "]에 있습니다.");
    }
}
