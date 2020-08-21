package doIt.ch03.practice;

import java.util.Scanner;

/**
 * 아래처럼 이진 검색의 과정을 자세히 출력하는 프로그램을 작성. 각 행의 맨 왼쪽에 현재 검색하고 있는 인덱스를 출력하고,
 * 검색 범위의 맨 앞 요소 위에 <-, 맨끝 요소 위에 ->, 현재 검색하고 있는 중앙 요소 위에 +를 출력.
 */
public class Q_03_04 {

    //요솟수가 n인 배열 a에서 key와 같은 요소를 이진 검색
    static int binSearch(int[] a, int n, int key) {
        int pl = 0; //검색 범위의 첫 인덱스
        int pr = n - 1; //검색 범위의 끝 인덱스

        System.out.print("   |");
        for (int i = 0; i < n; i++)
            System.out.printf("%4d", i);

        System.out.print("\n---+");
        for (int i = 0; i < n; i++)
            System.out.print("----");

        do {
            int pc = (pl + pr) / 2; //중앙 요소의 인덱스;

            System.out.print("\n   |");
            for (int i = pl; i <= pr; i++) {
                if(pc == i)
                    System.out.printf("%4c", '+');
                else if(pl == i)
                    System.out.printf("%4s", "<-");
                else if(pr == i)
                    System.out.printf("%4s", "->");
                else
                    System.out.print("    ");
            }

            System.out.print("\n "+pc+" |");
            for (int i = 0; i < n; i++)
                System.out.printf("%4d", a[i]);

            if(a[pc] == key)
                return pc;  //검색 성공
            else if(a[pc] < key)
                pl = pc + 1;    //검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1;    //검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);

        return -1;  //검색 실패
    }

    //답안지의 답
    static int binSearchEx(int[] a, int n, int key) {
        System.out.print("   |");
        for (int k = 0; k < n; k++)
            System.out.printf("%4d", k);
        System.out.println();

        System.out.print("---+");
        for (int k = 0; k < 4 * n + 2; k++)
            System.out.print("-");
        System.out.println();

        int pl = 0; // 검색범위 맨 앞의 index
        int pr = n - 1; // 검색범위 맨 뒤의 index

        do {
            int pc = (pl + pr) / 2; // 중앙요소의 index
            System.out.print("   |");
            if (pl != pc)
                System.out.printf(String.format("%%%ds<-%%%ds+", (pl * 4) + 1, (pc - pl) * 4), "", "");
            else
                System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
            if (pc != pr)
                System.out.printf(String.format("%%%ds->\n", (pr - pc) * 4 - 2), "");
            else
                System.out.println("->");
            System.out.printf("%3d|", pc);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[pc] == key)
                return pc; // 검색성공
            else if (a[pc] < key)
                pl = pc + 1; // 검색범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1; // 검색범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);
        return -1; // 검색실패
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

        int idx = binSearch(x, num, ky);
        System.out.println();

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println(ky+"은(는) X[" + idx + "]에 있습니다.");
    }
}
