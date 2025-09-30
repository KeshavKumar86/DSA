package binarysearch.leetcode;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Element Present at Index: " + search(arr, target));
    }

    private static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            //if we are in first half
            if (nums[mid] >= nums[0]) {
                if (nums[mid] < target || target < nums[0]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            //if we are in second half
            else {
                if (nums[mid] > target || target >= nums[0]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
