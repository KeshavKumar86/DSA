package array.leetcode;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum Subarray Sum: " + maximumSumSubarray(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int maximumSumSubarrayOptimal(int[] arr) {
        int maxSum = arr[0];
        int currSum = 0;
        for (int element : arr) {
            if (currSum < 0) {
                currSum = 0;
            }
            currSum += element;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int maximumSumSubarray(int[] arr) {
        int maxSum = arr[0];
        int currSum;
        for (int i = 0; i < arr.length; i++) {
            currSum = 0;
            for (int j = i; j < arr.length; j++) {
                currSum += arr[j];
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}
