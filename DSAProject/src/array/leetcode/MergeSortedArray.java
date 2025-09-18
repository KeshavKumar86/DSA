package array.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] arr2 = {2, 5, 6};
        int n = 3;
        merge(arr1, m, arr2, n);
        System.out.println("Merged Array: " + Arrays.toString(arr1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] < nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
