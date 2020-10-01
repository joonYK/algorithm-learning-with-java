package doIt.ch06;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 클래스 객체 배열의 정렬(병합 정렬)
 * 신체검사 데이터 배열을 정렬
 *
 * Comparator 클래스를 이용해서 오름차순 정렬 
 */
public class PhyscExamSort_06_15 {

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
                return (o1.height > o2.height) ? 1 :
                        (o1.height < o2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
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
        Arrays.sort(x, PhyscData.HEIGHT_ORDER);

        System.out.println("신체검사 리스트");
        System.out.println("이름      키       시력");
        System.out.println("---------------------");
        for (PhyscData physcData : x)
            System.out.println(physcData);


    }

}
