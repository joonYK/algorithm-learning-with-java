package codility.array;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Array2 {
    static int solution(int[] A) {
        Map<Integer, Integer> map = Arrays.stream(A).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(a -> 1)));

        for(int key : map.keySet()) {
            if(map.get(key) % 2 != 0)
                return key;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] A = {9,3,2,3,9,7,9};
        System.out.println(solution(A));
    }
}
