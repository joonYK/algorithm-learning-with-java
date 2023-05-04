package pocu.sort;

import java.util.Arrays;

public class Bubble {

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,11,13,7,2,1,73,42,10};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
