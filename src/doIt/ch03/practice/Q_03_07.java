package doIt.ch03.practice;

import doIt.ch03.PhysExamSearch_03_08;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 시력에 대한 내림차순 정렬의 신체검사 데이터에서 특정 시력을 가진 사람을 검색하는 프로그램 작성.
 * PhysExamSearch_03_08 기반
 */
public class Q_03_07 {

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

        public static final Comparator<PhyscData> VISION_ORDER = new PhyscData.VisionOrderComparator();

        //시력 내림차순 정렬위한 Comparator
        private static class VisionOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return Double.compare(o2.vision, o1.vision);
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        //키의 오름차순
        PhyscData[] x = {
                new PhyscData("이나령", 162, 2.0),
                new PhyscData("유지훈", 168, 1.5),
                new PhyscData("김한결", 169, 1.5),
                new PhyscData("홍준기", 171, 1.3),
                new PhyscData("전서형", 173, 0.7),
                new PhyscData("이호연", 174, 0.5),
                new PhyscData("이수민", 175, 0.2),
        };

        System.out.print("시력이 몇인 사람을 찾고 있나요 ? : ");
        double vision = stdIn.nextDouble();

        int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);

        if(idx < 0)
            System.out.println("요소가 없습니다.");
        else {
            System.out.println("X[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터 : " + x[idx]);
        }
    }
}
