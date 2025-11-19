package stack.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2, 0};
        int[] nums2 = {3, 4, 2, 0, 1};
        System.out.println("Next Greater Element: " + Arrays.toString(nextGreaterElementOptimal
                (nums1, nums2)));
    }

    /*
    Naive Solution:
    Time Complexity: O(n*m)
    Space Complexity: O(n)
    */
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] result = new int[len1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums2[len2 - 1], -1);
        for (int i = 0; i < len2; i++) {
            map.put(nums2[i], i);
        }
        for (int i = 0; i < len1; i++) {
            int key = nums1[i];
            int index = map.get(key);
            result[i] = nextMaxToRight(nums2, index);
        }
        return result;
    }

    private static int nextMaxToRight(int[] arr, int index) {
        int value = arr[index];
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[i] > value) {
                return arr[i];
            }
        }
        return -1;
    }

    /*
    Optimal Solution: Using monotonic stack
    Time Complexity: O(n+m)
    Space Complexity: O(n)
    */
    private static int[] nextGreaterElementOptimal(int[] nums1, int[] nums2) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            indexMap.put(nums1[i], i);
            res[i] = -1;
        }
        for (int element : nums2) {
            while (!stack.isEmpty() && stack.peek() < element) {
                int num = stack.pop();
                int index = indexMap.get(num);
                res[index] = element;
            }
            if (indexMap.containsKey(element)) {
                stack.push(element);
            }
        }
        return res;
    }
}
