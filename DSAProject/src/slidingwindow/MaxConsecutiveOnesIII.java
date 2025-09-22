package slidingwindow;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println("Longest Length: " + longestOnes(arr, k));
    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int longestOnesOptimal(int[] nums, int k) {
        int n = nums.length;
        int start = 0, end;
        int zeros = 0;
        int maxLength = 0;
        for (end = 0; end < n; end++) {
            // 1. Expand window by including nums[end]
            if (nums[end] == 0) {
                zeros++;
            }
            // 2. If condition violated, shrink from start
            while (zeros > k) {
                if (nums[start] == 0) {
                    zeros--;
                }
                start++;
            }
            // 3. Update result
            int windowSize = end - start + 1;
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }
    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int maxLength = 0;
        int zeros;
        for (int i = 0; i < n; i++) {
            zeros = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 0) {
                    zeros++;
                }
                if (zeros > k) {
                    break;
                }
                int windowSize = j - i + 1;
                maxLength = Math.max(maxLength, windowSize);
            }
        }
        return maxLength;
    }
}
