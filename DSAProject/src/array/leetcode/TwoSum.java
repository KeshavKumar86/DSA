package array.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Element's Index: " + Arrays.toString(twoSum(arr, target)));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int[] twoSumOptimal(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = {-1, -1};
        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            if (map.containsKey(key)) {
                result[0] = map.get(key);
                result[1] = i;
                return result;
            }
            map.put(arr[i], i);
        }
        return result;
    }
    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int[] twoSum(int[] arr, int target) {
        int n = arr.length;
        int[] result = {-1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
}
