package codility.binaryGap;

public class Test {
    static int solution(int N) {
        String binaryStr = Integer.toBinaryString(N);
        System.out.println(binaryStr);

        int maxGap = 0;
        int startIndex = binaryStr.indexOf('1');
        if(startIndex == -1)
            return 0;

        while(true) {
            int nextIndex = binaryStr.indexOf('1', startIndex+1);
            if(nextIndex == -1)
                break;

            int gap = nextIndex - startIndex - 1;

            if(gap == 0)
                nextIndex = 1;
            else if(gap > maxGap)
                maxGap = gap;

            startIndex += nextIndex;
        }

        // write your code in Java SE 8
        return maxGap;
    }

    public static void main(String[] args) {
        int gap = solution(1041);
        System.out.println("결과 : " + gap);
    }
}
