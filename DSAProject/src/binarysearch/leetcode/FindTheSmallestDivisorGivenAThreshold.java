package binarysearch.leetcode;

public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 9};
        int threshold = 6;
        System.out.println("Smallest Divisor: " + smallestDivisor(arr, threshold));
    }

    /*
Optimal Solution:
Time Complexity: O( n*log(max(nums)) )
Space Complexity:O(1)
*/
    public static int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = max(nums);
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (divisonSum(nums, mid) <= threshold) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }

    /*
Optimal Solution:
Time Complexity: O(n*max(nums))
Space Complexity:O(1)
*/
    public static int smallestDivisorNaive(int[] nums, int threshold) {
        int max = max(nums);
        for (int i = 1; i <= max; i++) {
            if (divisonSum(nums, i) <= threshold) {
                return i;
            }
        }
        return -1;
    }

    private static long divisonSum(int[] nums, int divisor) {
        long divisonSum = 0;
        for (int num : nums) {
            long divison = num / divisor;
            if (num % divisor == 0) {
                divisonSum += divison;
            } else {
                divisonSum += divison + 1;
            }
        }
        return divisonSum;
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
