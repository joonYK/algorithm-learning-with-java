package doIt.ch03;

import java.util.Scanner;

/**
 * 선형 검색 (보초법)
 */
public class SeqSearch_03_03 {

    //요솟수가 n인 배열 a에서 key와 같은 요소를 선형 검색
    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        a[n] = key; //보초를 추가

        while (true) {
            if (a[i] == key)    //기존 SeqSearch_03_01에서 if(i == n)이 없기때문에 판단 횟수가 절반으로 줄어든다.
                break;
            i++;
        }

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
