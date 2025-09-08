package array.leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Majority Element: " + majorityElementBetter(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int majorityElementOptimal(int[] arr) {
        int majorityElement = 0, count = 0;
        for (int element : arr) {
            if (count == 0) {
                majorityElement = element;
                count++;
            } else if (element != majorityElement) {
                count--;
            } else {
                count++;
            }
        }
        return majorityElement;
    }

    /*
Better Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int majorityElementBetter(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = arr.length / 2;
        for (int element : arr) {
            map.put(element, map.getOrDefault(element, 0) + 1);
            if (map.get(element) > n) {
                return element;
            }
        }
        return -1;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int majorityElement(int[] arr) {
        for (int element : arr) {
            int count = 0;
            for (int element2 : arr) {
                if (element == element2) {
                    count++;
                }
            }
            if (count > arr.length / 2) {
                return element;
            }
        }
        return -1;
    }
}
