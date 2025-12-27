package array.learning;

import java.util.Arrays;

public class MaximumSubarraySumInAnArray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray: " + Arrays.toString(maximumSumSubarray(arr)));

    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int[] maximumSumSubarray(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int currSum = 0;
        int startIndex = 0, endIndex = 0;
        int potentialStart = 0;
        for (int i = 0; i < n; i++) {
            if (currSum == 0) {
                potentialStart = i;
            }
            currSum += nums[i];
            if (currSum > maxSum) {
                maxSum = currSum;
                startIndex = potentialStart;
                endIndex = i;
            }
            currSum = Math.max(currSum, 0);
        }
        int length = endIndex - startIndex + 1;
        int[] res = new int[length];
        System.arraycopy(nums, startIndex, res, 0, length);
        return res;
    }
        /*
Naive Solution: Find all subarray and see who has the max sum, return that subarray
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
}
