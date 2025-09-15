package array.leetcode;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(arr);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

    /*
Optimal Solution:
Time Complexity: O(n^2)
Space Complexity:O(n)
*/
    private static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int tripleSum = nums[i] + nums[low] + nums[high];
                if (tripleSum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[low]);
                    list.add(nums[high]);
                    Collections.sort(list);
                    result.add(list);
                    low++;
                } else if (tripleSum > 0) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    /*
Naive Solution:
Time Complexity: O(n^3)
Space Complexity:O(n)
*/
    private static List<List<Integer>> threeSumNaive(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        Collections.sort(list);
                        result.add(list);
                    }
                }
            }
        }
        return new ArrayList<>(result);
    }
}
