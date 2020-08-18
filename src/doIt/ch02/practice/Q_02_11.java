package doIt.ch02.practice;

import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.TemporalField;
import java.util.Date;
import java.util.Random;

/**
 * 서기 년월일을 필드로 갖는 클래스를 생성.
 *
 * - 생성자(주어진 날짜로 설정)
 * YMD(int y, int m, int d)
 * - n일 뒤의 날짜를 반환
 * YMD after(int)
 * - n일 앞의 날짜를 반환
 * YMD before(int n)
 */
public class Q_02_11 {

    //각 달의 일수
    static int[][] mdays = {
            {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //평년
            {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}, //윤년
    };

    //윤년인지 확인 (1 : 윤년)
    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static class YMD {
        private int y;
        private int m;
        private int d;

        public YMD(int y, int m, int d) {
            this.y = y;
            this.m = m;
            this.d = d;
        }

        public YMD after(int n) {
            YMD ymd = new YMD(y,m,d);
            int days = mdays[isLeap(ymd.y)][ymd.m-1];

            for (int i = 0; i < n; i++) {
                if(ymd.d == days) {
                    if(ymd.m == 12) {
                        ymd.y++;
                        ymd.m = 1;
                    } else {
                        ymd.m++;
                    }
                    ymd.d = 0;
                    days = mdays[isLeap(ymd.y)][ymd.m-1];
                }

                ymd.d++;
            }

            return ymd;
        }

        public YMD before(int n) {
            YMD ymd = new YMD(y,m,d);

            for (int i = 0; i < n; i++) {
                if(ymd.d == 1) {
                    if(ymd.m == 1) {
                        ymd.y--;
                        ymd.m = 12;
                    } else {
                        ymd.m--;
                    }
                    ymd.d = mdays[isLeap(ymd.y)][ymd.m-1];
                } else {
                    ymd.d--;
                }
            }

            return ymd;
        }

        //답안지의 답
        /*YMD after(int n) {
            YMD temp = new YMD(this.y, this.m, this.d);
            if (n < 0)
                return (before(-n));

            temp.d += n;

            while (temp.d > mdays[isLeap(temp.y)][temp.m - 1]) {
                temp.d -= mdays[isLeap(temp.y)][temp.m - 1];
                if (++temp.m > 12) {
                    temp.y++;
                    temp.m = 1;
                }
            }
            return temp;
        }*/

        //답안지의 답
        /*YMD before(int n) {
            YMD temp = new YMD(this.y, this.m, this.d);
            if (n < 0)
                return (after(-n));

            temp.d -= n;

            while (temp.d < 1) {
                if (--temp.m < 1) {
                    temp.y--;
                    temp.m = 12;
                }
                temp.d += mdays[isLeap(temp.y)][temp.m - 1];
            }
            return temp;
        }*/
    }

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        YMD date = new YMD(now.getYear(), now.getMonthValue(), now.getDayOfMonth());

        System.out.printf("날짜 : %d년 %d월 %d일\n", date.y, date.m, date.d);

        int after = new Random().nextInt(100);
        System.out.printf("%d일 뒤의 날짜를 구함\n", after);

        YMD afterDate = date.after(after);
        System.out.printf("날짜 : %d년 %d월 %d일\n", afterDate.y, afterDate.m, afterDate.d);

        int before = new Random().nextInt(1000);
        System.out.printf("%d일 이전의 날짜를 구함\n", before);

        YMD beforeDate = date.before(before);
        System.out.printf("날짜 : %d년 %d월 %d일\n", beforeDate.y, beforeDate.m, beforeDate.d);

    }
}
