package array.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Longest Consecutive Sequence Length: " + longestConsecutive(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int longestConsecutiveOptimal(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int element : arr) {
            set.add(element);
        }
        for (int element : set) {
            if (!set.contains(element - 1)) {
                int count = 1;
                while (set.contains(element + count)) {
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    /*
Better Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        for (int num : nums) {
            if (map.containsKey(num - 1)) {
                map.put(num, false);
            } else
                map.put(num, true);
            if (map.containsKey(num + 1))
                map.put(num + 1, false);
        }
        Set<Integer> keySet = map.keySet();
        int maxLength = 1;
        for (Integer key : keySet) {
            if (map.get(key)) {
                int currLength = 1;
                while (true) {
                    if (map.containsKey(key + currLength)) {
                        currLength++;
                        if (currLength > maxLength)
                            maxLength = currLength;
                    } else
                        break;
                }
            }
        }
        return maxLength;
    }
        /*
Naive Solution: Sort the array and then find the length of longest consecutive sequence
Time Complexity: O(n*Logn)
Space Complexity:O(1)
*/
}
