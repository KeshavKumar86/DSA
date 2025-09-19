package array.leetcode;

import java.util.Arrays;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 5, 6, 8, 12, 0, 0, 0, 0, 0};
        int m = 6;
        int[] arr2 = {2, 3, 5, 7, 10};
        int n = 5;
        mergeNaive(arr1, m, arr2, n);
        System.out.println("Merged Array: " + Arrays.toString(arr1));
    }

    /*
Optimal Solution:
Time Complexity: O(n+m)
Space Complexity:O(1)
*/
    private static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1, j = n - 1, k = nums1.length - 1;
        while (j >= 0 && i >= 0) {
            if (nums1[i] <= nums2[j]) {
                nums1[k--] = nums2[j--];
            } else {
                nums1[k--] = nums1[i--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    /*
Better Solution: copy the m elements from num1 to some other temp array and then using temp array and
num2 use merge procedure and store the elements in the num1 array.
Time Complexity: O(n+m)
Space Complexity:O(m)
*/
    /*
Naive Solution:
Time Complexity: O((n+m)*log(n+m))
Space Complexity:O(1)
*/
    private static void mergeNaive(int[] nums1, int m, int[] nums2, int n) {
        int j = 0;
        for (int i = m; i < n + m; i++) {
            nums1[i] = nums2[j++];
        }
        Arrays.sort(nums1);
    }
}
