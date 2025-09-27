package slidingwindow.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubarraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 3, 4};
        int k = 3;
        System.out.println("Total Sub-arrays: " + subarraysWithKDistinctNaive(arr, k));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(k)
*/
    private static int subarraysWithKDistinct(int[] nums, int k) {
        return countLessThanEqualK(nums, k) - countLessThanEqualK(nums, k - 1);
    }

    private static int countLessThanEqualK(int[] nums, int k) {
        int count = 0;
        int start = 0, end;
        Map<Integer, Integer> map = new HashMap<>();
        for (end = 0; end < nums.length; end++) {
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            while (map.size() > k) {
                int key = nums[start];
                if (map.get(key) == 1) {
                    map.remove(key);
                } else {
                    map.put(key, map.get(key) - 1);
                }
                start++;
            }
            int windowSize = end - start + 1;
            count += windowSize;
        }
        return count;
    }
    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(k)
*/
    private static int subarraysWithKDistinctNaive(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                if (set.size() == k) {
                    count++;
                } else if (set.size() > k) {
                    break;
                }
            }
        }
        return count;
    }
}
