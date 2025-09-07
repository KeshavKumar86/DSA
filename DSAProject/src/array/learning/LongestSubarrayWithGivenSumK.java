package array.learning;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSumK {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 9, 8};
        int k = 8;
        System.out.println("Length of the Longest Subarray: " + subarrayLengthOptimal(arr, k));
    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int subarrayLengthOptimal(int[] arr, int k) {
        int prefixSum = 0;
        int maxLength = 0;
        int start = 0, end = 0;
        while (end < arr.length) {
            prefixSum += arr[end];
            while (start <= end && prefixSum > k) {
                prefixSum -= arr[start++];
            }
            if (prefixSum == k) {
                maxLength = Math.max(maxLength, end - start + 1);
            }
            end++;
        }
        return maxLength;
    }

    /*
Better Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int subarrayLength(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLength = 0;
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (map.containsKey(prefixSum - k)) {
                maxLength = Math.max(maxLength, i - map.get(prefixSum - k));
            }
            map.put(prefixSum, i);
        }
        return maxLength;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int subarrayLengthNaive(int[] arr, int k) {
        int maxLength = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
