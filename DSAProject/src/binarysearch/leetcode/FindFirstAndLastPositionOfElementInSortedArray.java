package binarysearch.leetcode;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println("First & Last Occurrence Index: " + Arrays.toString(searchRange(arr, target)));
    }

    /*
Optimal Solution:
Time Complexity: O(2*logn)
Space Complexity:O(1)
*/
    private static int[] searchRange(int[] nums, int target) {
        int firstIndex = binSearch(nums, target, true);
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }
        int lastIndex = binSearch(nums, target, false);
        return new int[]{firstIndex, lastIndex};
    }

    private static int binSearch(int[] nums, int target, boolean firstOccurence) {
        int left = 0;
        int right = nums.length - 1;
        int resIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                resIndex = mid;
                if (firstOccurence) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resIndex;
    }

    private static int[] searchRangeNaive(int[] nums, int target) {
        int n = nums.length;
        int firstIndex = -1, lastIndex = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                firstIndex = i;
                break;
            }
        }
        for (int i = firstIndex + 1; i < n; i++) {
            if (nums[i] > target) {
                lastIndex = i - 1;
                break;
            }
        }
        if (firstIndex == -1) {
            return new int[]{-1, -1};
        }
        if (lastIndex == -1) {
            return new int[]{firstIndex, n - 1};
        }
        return new int[]{firstIndex, lastIndex};
    }
}
