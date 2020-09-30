package doIt.ch06;

import java.util.Arrays;
import java.util.GregorianCalendar;
import static java.util.GregorianCalendar.*;

/**
 * 클래스 객체 배열의 정렬(병합 정렬)
 * 달력의 배열을 정렬
 *
 * GregorianCalendar 클래스가 구현한 Comparable 인터페이스의 CompareTo 메서드를
 * 사용해서 비교.
 */
public class SortCalendar_06_14 {
    public static void main(String[] args) {
        GregorianCalendar[] x = {
                new GregorianCalendar(2017, GregorianCalendar.NOVEMBER, 1),
                new GregorianCalendar(1963, GregorianCalendar.OCTOBER, 18),
                new GregorianCalendar(1985, GregorianCalendar.APRIL, 5)
        };

        Arrays.sort(x);

        for (GregorianCalendar gregorianCalendar : x)
            System.out.printf("%04d년 %02d월 %02d일\n",
                    gregorianCalendar.get(YEAR),
                    gregorianCalendar.get(MONTH) + 1,
                    gregorianCalendar.get(DATE)
            );
    }
}
