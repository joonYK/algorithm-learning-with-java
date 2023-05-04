package pocu.sort;

import java.util.Arrays;

public class Selection {

    static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (arr[minIdx] > arr[j]) {
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,11,7,6,1,10,42,10,20,15};
        Bubble.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
