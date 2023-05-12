package pocu.sort;

import java.util.Arrays;

public class Insertion {

    static void sort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            while (i > 0 && arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
                i--;
            }
        }
    }

    static void sort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];

            while (i > 0 && temp < arr[i - 1]) {
                arr[i] = arr[i - 1];
                i--;
            }

            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,11,7,6,1,10,42,10,20,15,34};
        Insertion.sort2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
