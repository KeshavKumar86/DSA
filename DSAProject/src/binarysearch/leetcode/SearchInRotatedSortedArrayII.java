package binarysearch.leetcode;

public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] arr = {2, 5, 6, 0, 0, 1, 2};
        int target = 0;
        System.out.println("Is Target Present: " + search(arr, target));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            //we can be in second half or first half
            if (nums[left] == nums[mid] && nums[mid] == nums[right]) {
                left++;
                right--;
                continue;
            }
            //if we are in first half
            if (nums[mid] >= nums[left]) {
                if (nums[mid] < target || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //if we are in second half
            else {
                if (nums[mid] > target || target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;
    }

}
