package binarysearch.leetcode;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1}, nums2 = {};
        System.out.println("Median is: " + findMedianSortedArrays(nums1, nums2));

    }

    private static double findMedianSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if (n == 0 && m == 0) {
            return 0;
        }
        int[] arr = new int[n + m];
        int i = 0, j = 0, k = 0;
        while (i < n && j < m) {
            if (a[i] < b[j]) {
                arr[k] = a[i];
                i++;
            } else {
                arr[k] = b[j];
                j++;
            }
            k++;
        }
        while (i < n) {
            arr[k] = a[i];
            i++;
            k++;
        }
        while (j < m) {
            arr[k] = b[j];
            j++;
            k++;
        }
        System.out.println("Merged Array: " + Arrays.toString(arr));
        int start = 0, end = m + n - 1;
        int mid = (start + end) / 2;
        if ((m + n) % 2 == 0) {
            return (arr[mid] + arr[mid + 1]) / 2.0;
        } else {
            return arr[mid];
        }
    }
}
