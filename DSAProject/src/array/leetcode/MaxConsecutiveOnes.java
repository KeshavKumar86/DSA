package array.leetcode;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] arr = {1, 1, 0, 1, 1, 1};
        System.out.println("No of Consecutive 1's: " + maxConsecutiveOnes(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int maxConsecutiveOnesOptimal(int[] arr) {
        int max = 0, currentMax = 0;
        for (int element : arr) {
            if (element == 1) {
                currentMax++;
            } else {
                max = Math.max(max, currentMax);
                currentMax = 0;
            }
        }
        return Math.max(max, currentMax);
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int maxConsecutiveOnes(int[] nums) {
        int maxCount = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int currentCount = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 1) {
                    currentCount++;
                    maxCount = Math.max(maxCount, currentCount);
                } else {
                    break;  // Stop counting when we hit a 0
                }
            }
        }

        return maxCount;
    }

}
