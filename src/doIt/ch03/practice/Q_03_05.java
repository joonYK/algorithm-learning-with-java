package doIt.ch03.practice;

import java.util.Scanner;

/**
 * 이진 검색 알고리즘 프로그램은 검색할 값과 같은 값을 갖는 요소가 하나 이상일 경우 그 요소 중에서 맨 앞의 요소를 찾지 못함.
 * 예를 들어 아래 배열에서 7을 검색하면 중앙에 위치하는 a[5]를 검색. 맨 앞의 요소를 찾는 binSearchX 메서드를 작성.
 *
 * {1, 3, 5, 7, 7, 7, 8, 8, 9, 9}
 *
 * static int binSearchX(int[] a, int n, int key)
 */
public class Q_03_05 {
    //요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
    static int binSearchX(int[] a, int n, int key) {
        int pl = 0; //검색 범위의 첫 인덱스
        int pr = n - 1; //검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr) / 2; //중앙 요소의 인덱스;
            if(a[pc] == key) {
                //풀이
                while(pc > pl) {
                    if(a[pc - 1] == a[pc])
                        pc--;
                    else
                        break;
                }

                //답안지의 답
                /*for (; pc > pl; pc--) // key와 같은 맨 앞의 요소를 찾습니다
                    if (a[pc - 1] < key)
                        break;*/

                return pc;  //검색 성공
            } else if(a[pc] < key)
                pl = pc + 1;    //검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1;    //검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1;  //검색 실패
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요솟수가 num인 배열

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("x[0] : ");    //첫 요소 입력
        x[0] = stdIn.nextInt();

        for (int i = 1; i < num; i++) {
            do {
                System.out.print("X[" + i + "] : ");
                x[i] = stdIn.nextInt();
            } while (x[i] < x[i - 1]);  //바로 앞의 요소보다 작으면 다시 입력
        }

        System.out.print("검색할 값 : ");   //키 값 입력
        int ky = stdIn.nextInt();

        int idx = binSearchX(x, num, ky);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) X[" + idx + "]에 있습니다.");
    }

}
