package pocu.sort;

import java.util.Arrays;
import java.util.Random;

public class Quick {

    public static void sort(int[] arr) {
        sortRecursive(arr, 0, arr.length - 1);
    }

    private static void sortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotPos = partition(arr, left, right);
        sortRecursive(arr, left, pivotPos - 1);
        sortRecursive(arr, pivotPos + 1, right);
    }

    private static int partition(int[] arr, int left, int right) {
        //int pivot = arr[right];
        int pivot = randomPivot(arr, left, right);

        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }

        swap(arr, i, right);
        return i;
    }

    private static final Random random = new Random();

    private static int randomPivot(int[] arr, int left, int right) {
        int pivotIndex = random.nextInt(right - left + 1) + left;
        swap(arr, pivotIndex, right);
        return arr[right];
    }

    private static void swap(int[] arr, int pos1, int pos2) {
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,11,2,7,6,1,10,17,95,42,10,20,15,34};
        Quick.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
