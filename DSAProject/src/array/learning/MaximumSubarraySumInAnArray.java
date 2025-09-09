package array.learning;

import java.util.Arrays;

public class MaximumSubarraySumInAnArray {
    public static void main(String[] args) {
        int[] arr = {5, 4, -1, 7, 8};
        int[] res = {-1, -1, -1};
        System.out.println("Maximum Subarray: " + Arrays.toString(maximumSumSubarray(arr)));

    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int[] maximumSumSubarray(int[] arr) {
        int maxSum = arr[0];
        int currSum = 0;
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            if (currSum < 0) {
                currSum = 0;
                startIndex = i;
                endIndex = i;
            }
            currSum += arr[i];
            if (maxSum < currSum) {
                maxSum = currSum;
                endIndex = i;
            }
        }
        int length = endIndex - startIndex + 1;
        int[] res = new int[length];
        System.arraycopy(arr, startIndex, res, 0, length);
        return res;
    }
        /*
Naive Solution: Find all subarray and see who has the max sum, return that subarray
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
}
