package binarysearch.leetcode;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 5, 6, 4};
        System.out.println("Peak Element's Index: " + findPeakElement(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int findPeakElement(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid == n - 1) {
                return n - 1;
            }
            if (nums[mid] < nums[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int findPeakElementNaive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((i == 0 || nums[i - 1] < nums[i]) && (i == n - 1 || nums[i] > nums[i + 1])) {
                return i;
            }
        }
        return -1;
    }
}
