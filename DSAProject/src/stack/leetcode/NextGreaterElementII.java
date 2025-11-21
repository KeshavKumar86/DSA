package stack.leetcode;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {
        int[] nums = {5, 1, 4};
        System.out.println("Next Greater Element: " + Arrays.toString(nextGreaterElements(nums)));
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
}
