package stack.gfg;

import java.util.*;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 4, 6, 5, 7, 9};
        System.out.println("Next Smaller Element: " + nextSmallerEleNaive(nums));
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(n)
  */
    private static ArrayList<Integer> nextSmallerEle(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int ignored : arr) {
            res.add(-1);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                int index = stack.pop();
                res.set(index, arr[i]);
            }
            stack.push(i);
        }
        return res;
    }
    /*
  Naive Solution:
  Time Complexity: O(n^2)
  Space Complexity:O(1)
  */
    private static ArrayList<Integer> nextSmallerEleNaive(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int ignored : arr) {
            res.add(-1);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    res.set(i, arr[j]);
                    break;
                }
            }
        }
        return res;
    }
}
