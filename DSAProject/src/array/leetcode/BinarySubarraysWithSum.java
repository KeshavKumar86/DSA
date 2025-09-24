package array.leetcode;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] arr = {1, 0, 1, 0, 1, 0};
        int goal = 2;
        System.out.println("Total Sub-arrays: " + numSubarraysWithSum(arr, goal));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int numSubarraysWithSum(int[] nums, int goal) {
        return sumLessEqualToGoal(nums, goal) - sumLessEqualToGoal(nums, goal - 1);
    }

    private static int sumLessEqualToGoal(int[] nums, int goal) {
        int count = 0;
        int start = 0, end;
        int sum = 0;
        if (goal < 0) {
            return 0;
        }
        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum > goal) {
                sum -= nums[start];
                start++;
            }
            count += (end - start + 1);
        }
        return count;
    }

    /*
Better Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int numSubarraysWithSumBetter(int[] nums, int goal) {
        int count = 0;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            prefixSum += num;
            if (map.containsKey(prefixSum - goal)) {
                count += map.get(prefixSum - goal);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int numSubarraysWithSumNaive(int[] nums, int goal) {
        int n = nums.length;
        int totalSubarray = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum == goal) {
                    totalSubarray++;
                }
            }
        }
        return totalSubarray;
    }
}
