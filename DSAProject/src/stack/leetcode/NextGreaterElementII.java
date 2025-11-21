package stack.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5, 7, 9};
        System.out.println("Next Greater Element: " + Arrays.toString(nextGreaterElementsNaive(nums)));
    }

    /*
     Optimal Solution: Using monotonic stack
     Time Complexity: O(2*n)
     Space Complexity: O(n)
     */
    private static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                int index = stack.pop();
                res[index] = num;
            }
            if (i < n) {
                stack.push(i);
            }
        }
        return res;
    }

    /*
    Naive Solution: Brute Force Solution
    Time Complexity: O(n^2)
    Space Complexity: O(n)
    */
    private static int[] nextGreaterElementsNaive(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < i + n; j++) {
                if (nums[j % n] > nums[i]) {
                    res[i] = nums[j % n];
                    break;
                }
            }
        }
        return res;
    }
}
