package codility.array;

import java.util.Arrays;
import java.util.LinkedList;

public class Array1 {
    static int[] solution(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < A.length; i++)
            list.add(A[i]);

        for (int i = 0; i < K; i++)
            list.add(0, list.remove(list.size() - 1));

        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        System.out.println(Arrays.toString(solution(A, 4)));
    }
}
