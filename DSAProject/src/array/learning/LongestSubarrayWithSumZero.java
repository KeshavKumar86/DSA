package array.learning;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithSumZero {
    public static void main(String[] args) {
        int[] arr = {9, -3, 3, -1, 6, -5};
        System.out.println("Longest Subarray Length: " + longestSubarrayOptimal(arr));

    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int longestSubarrayOptimal(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum));
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLength;
    }
}
    /*
Naive Solution: generate all subarray and find the length and compare with max length
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
