package doIt.ch07.practice;

/**
 * 클래스 IntSet에 집합이 비어 있는 공집합인지를 판단하는 메서드, 가득 찼는지를 판단하는
 * 메서드, 모든 요소를 삭제하는 메서드를 추가.
 * boolean isEmpty()    //공집합인지 확인
 * boolean isFull()     //집합이 가득 찼는지 확인.
 * void clear()         //집합을 초기화(모든 요소 삭제)
 *
 * */
public class Q_07_01 {
    static class IntSet {
        //집합의 최대 개수
        private int max;
        //집합의 요소 개수
        private int num;
        //집합 본체
        private int[] set;

        //생성자
        public IntSet(int capacity) {
            num = 0;
            max = capacity;

            try {
                //집합 배열 생성
                set = new int[max];
            } catch (OutOfMemoryError e) {
                max = 0;
            }
        }

        //집합의 최대 개수
        public int capacity() {
            return max;
        }

        //집합의 요소 개수
        public int size() {
            return num;
        }

        //집합에서 n을 검색(index 반환)
        public int indexOf(int n) {
            for (int i = 0; i < num; i++)
                if (set[i] == n)
                    return i;
            return -1;
        }

        //집합에 n이 있는지 확인
        public boolean contains(int n) {
            return indexOf(n) != -1;
        }

        //집합에 n을 추가
        public boolean add(int n) {
            if (num >= max || contains(n))
                return false;
            else
                set[num++] = n;

            return true;
        }

        //집합에서 n을 삭제
        public boolean remove(int n) {
            int idx;

            //비어있거나 n이 존재하지 않으면 실패
            if (num <= 0 || (idx = indexOf(n)) == -1)
                return false;
            else {
                //마지막 요소를 삭제한 곳으로 옮김
                set[idx] = set[--num];
                return true;
            }
        }

        //집합 s에 복사
        public void copyTo(IntSet s) {
            //복사할 요소 개수
            int n = s.max < num ? s.max : num;
            for (int i = 0; i < n; i++)
                s.set[i] = set[i];
            s.num = n;
        }

        //집합 s를 복사
        public void copyFrom(IntSet s) {
            int n = max < s.num ? max : s.num;
            for (int i = 0; i < n; i++)
                set[i] = s.set[i];
            num = n;
        }

        //집합 s와 같은지 확인
        public boolean equalTo(IntSet s) {
            //요소 개수가 같지 않으면 집합도 같지 않음
            if (num != s.num)
                return false;

            for (int i = 0; i < num; i++) {
                int j = 0;
                for (; j < s.num; j++) {
                    if (set[i] == s.set[j])
                        break;
                }
                //set[i]는 s에 포함되지 않음
                if (j == s.num)
                    return false;
            }

            return true;
        }

        //집합 s1과 s2의 합집합을 복사
        public void unionOf(IntSet s1, IntSet s2) {
            //집합 s1을 복사
            copyFrom(s1);
            //집합 s2의 요소를 추가
            for (int i = 0; i < s2.num; i++)
                add(s2.set[i]);
        }

        //"{a, b, c}"형식의 문자열로 표현
        @Override
        public String toString() {
            StringBuffer temp = new StringBuffer("{ ");
            for (int i = 0; i < num; i++)
                temp.append(set[i] + " ");
            temp.append("}");
            return temp.toString();
        }

        //공집합인지 확인
        public boolean isEmpty() {
            return num == 0;
        }

        //집합이 가득 찼는지 확인
        public boolean isFull() {
            return num >= max;
        }

        //모든 요소 삭제
        public void clear() {
            num = 0;
        }

    }

    public static void main(String[] args) {
        Q_07_01.IntSet set = new Q_07_01.IntSet(10);

        for (int i = 0; i < set.max; i++)
            set.add(i);

        System.out.println("set = " + set);
        System.out.println("isEmpty : " + set.isEmpty());
        System.out.println("isFull : " + set.isFull());

        System.out.println("\nclear execute");
        set.clear();
        System.out.println("set = " + set);
        System.out.println("isEmpty : " + set.isEmpty());
        System.out.println("isFull : " + set.isFull());
    }
}



