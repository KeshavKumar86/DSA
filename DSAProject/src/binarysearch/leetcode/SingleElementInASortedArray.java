package binarysearch.leetcode;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println("Single Element: " + singleNonDuplicate(arr));
    }
    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((mid == 0 || nums[mid - 1] != nums[mid]) && (mid == n - 1 || nums[mid] != nums[mid + 1])) {
                return nums[mid];
            }
            if (mid % 2 == 0) {
                if (nums[mid - 1] == nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid - 1] == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int singleNonDuplicateNaive(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i = i + 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }
        return nums[n - 1];
    }
}
