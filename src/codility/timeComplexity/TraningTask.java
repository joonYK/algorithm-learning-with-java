package codility.timeComplexity;

import java.util.HashMap;
import java.util.Map;

public class TraningTask {
    static int solution(int[] A) {
        Map<Integer, Boolean> map = new HashMap<>();

        for(int i : A)
            map.put(i, true);

        int result = 1;
        while (true) {
            if(!map.containsKey(result))
                break;

            result++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] A = {2,3,1,5};
        System.out.println(solution(A));
    }
}
