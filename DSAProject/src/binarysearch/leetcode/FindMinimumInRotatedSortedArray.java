package binarysearch.leetcode;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println("Minimum Element: " + findMinOptimal(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int findMinOptimal(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        // if the array is not rotated at all
        return nums[left % n];
    }

    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int findMin(int[] nums) {
        int n = nums.length;
        int min = nums[0];
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}
