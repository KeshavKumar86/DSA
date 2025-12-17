package array.leetcode;

import java.util.*;

public class MajorityElementII {
    public static void main(String[] args) {
        int[] arr = {2, 1};
        System.out.println("Majority Element: " + majorityElementBetter(arr));

    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int maj1 = 0;
        int maj2 = 0;
        int count1 = 0;
        int count2 = 0;
        for (int element : nums) {
            if (element == maj1) {
                count1++;
            } else if (element == maj2) {
                count2++;
            } else if (count1 == 0) {
                maj1 = element;
                count1 = 1;
            } else if (count2 == 0) {
                maj2 = element;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        List<Integer> result = new ArrayList<>();
        for (int element : nums) {
            if (element == maj1) {
                count1++;
            }
           else if (element == maj2) {
                count2++;
            }
        }
        if (count1 > n / 3) {
            result.add(maj1);
        }
        if (count2 > n / 3) {
            result.add(maj2);
        }
        Collections.sort(result);
        return result;
    }

    /*
Better Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static List<Integer> majorityElementBetter(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int element : nums) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            if (map.get(key) > n / 3) {
                result.add(key);
            }
        }
        return result;
    }
        /*
Naive Solution: Iterate the array and check the frequency of each element, and do it for all elements
and of the frequency is >n/3 add this into a set, finally convert set to list and return.
Time Complexity: O(n^2)
Space Complexity:O(n)
*/
}
