package pocu.sort;

import java.util.Arrays;

public class Merge {

    public static int[] sort(int[] arr) {
        return splitAndMerge(arr, 0, arr.length - 1);
    }

    public static int[] splitAndMerge(int[] arr, int left, int right) {
        if (left >= right) {
            return new int[]{arr[left]};
        }

        int middle = (left + right) / 2;
        int[] leftArr = splitAndMerge(arr, left, middle);
        int[] rightArr = splitAndMerge(arr, middle + 1, right);

        return merge(leftArr, rightArr);
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] mergedArr = new int[arr1.length + arr2.length];
        int idxOfArr1 = 0;
        int idxOfArr2 = 0;
        int idxOfMergedArr = 0;

        while (idxOfArr1 < arr1.length && idxOfArr2 < arr2.length) {
            if (arr1[idxOfArr1] < arr2[idxOfArr2]) {
                mergedArr[idxOfMergedArr++] = arr1[idxOfArr1++];
            } else {
                mergedArr[idxOfMergedArr++] = arr2[idxOfArr2++];
            }
        }

        while (idxOfArr1 < arr1.length) {
            mergedArr[idxOfMergedArr++] = arr1[idxOfArr1++];
        }

        while (idxOfArr2 < arr2.length) {
            mergedArr[idxOfMergedArr++] = arr2[idxOfArr2++];
        }

        return mergedArr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,3,11,2,7,6,1,10,17,95,42,10,20,15,34};
        System.out.println(Arrays.toString(Merge.sort(arr)));
    }
}
