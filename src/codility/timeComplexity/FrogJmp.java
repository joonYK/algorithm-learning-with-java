package codility.timeComplexity;

public class FrogJmp {
    static int solution(int X, int Y, int D) {
        int count = 0;
        int distance = Y - X;
        count = distance / D;

        if(distance % D > 0)
            count++;

        return count;
    }

    public static void main(String[] args) {
        int X = 10;
        int Y = 85;
        int D = 30;

        System.out.println(solution(X, Y, D));
    }
}
