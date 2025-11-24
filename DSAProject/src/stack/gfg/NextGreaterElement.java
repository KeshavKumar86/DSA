package stack.gfg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr = {5, 4, 3, 1};
        System.out.println("Next Greater Element: " + nextLargerElement(arr));
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(n)
  */
    private static ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for (int ignored : arr) {
            res.add(-1);
        }
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                int index = stack.pop();
                res.set(index, arr[i]);
            }
            stack.push(i);
        }
        return res;
    }
        /*
  Naive Solution: For every element iterate its right and check if greater element found, if found
  store in the result and break the loop.
  Time Complexity: O(n^2)
  Space Complexity:O(1)
  */
}
