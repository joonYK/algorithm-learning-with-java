package doIt.ch06.practice;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 실습 6-15 ( PhyscExamSort_06_15 )의 배열 x를 키의 오름차순이 아니라
 * 시력의 내림차순으로 정렬하는 프로그램을 작성.
 */
public class Q_06_16 {

    static class PhyscData {
        String name;
        int height;
        double vision;

        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return name + "     " + height + "      " + vision;
        }

        //키 오름차순용 comparator
        static final Comparator<PhyscData> HEIGHT_ORDER = new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return Integer.compare(o1.height, o2.height);
            }
        }

        //시력 오름차순용 comparator
        static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            @Override
            public int compare(PhyscData o1, PhyscData o2) {
                return Double.compare(o2.vision, o1.vision);
            }
        }
    }

    public static void main(String[] args) {
        PhyscData[] x = {
                new PhyscData("이나령", 162, 0.3),
                new PhyscData("전서현", 173, 0.7),
                new PhyscData("이수민", 175, 2.0),
                new PhyscData("홍준기", 171, 1.5),
                new PhyscData("유지훈", 168, 0.4),
                new PhyscData("이호연", 174, 1.2),
                new PhyscData("김한결", 169, 0.8),
        };

        //배열 x를 HEIGHT_ORDER을 사용하여 정렬
        Arrays.sort(x, PhyscData.VISION_ORDER);

        System.out.println("신체검사 리스트");
        System.out.println("이름      키       시력");
        System.out.println("---------------------");
        for (PhyscData physcData : x)
            System.out.println(physcData);


    }

}
