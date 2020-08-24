package doIt.ch03;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 신체검사 데이터 배열에서 이진 검색
 */
public class PhysExamSearch_03_08 {

    //신체검사 데이터 정의
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + " " + height + " " + vision;
        }

        public static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        //오름차순으로 정렬하기 위한 comparator
        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return (o1.height > o2.height) ? 1 : (o1.height < o2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        //키의 오름차순
        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("김한결", 169, 1.5),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("전서형", 173, 0.7),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("이수민", 175, 2.0),
        };

        System.out.print("몇 cm인 사람을 찾고 있나요 ? : ");
        int height = stdIn.nextInt();

        //배열의 요소가 어떤 순서로 줄지어 있는지, 각 요소의 대소 관계를 어떻게 판단할 것인지 PhyscData.HEIGHT_ORDER 전달.
        int idx = Arrays.binarySearch(x, new PhyscData("", height, 0.0), PhyscData.HEIGHT_ORDER);

        if(idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("X[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}
