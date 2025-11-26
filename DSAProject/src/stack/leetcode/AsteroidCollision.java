package stack.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = {8, 8, 8, -8};
        System.out.println("Final Result: " + Arrays.toString(asteroidCollision(arr)));
    }

/*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
*/
    private static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && stack.peek() < Math.abs(asteroid)) {
                stack.pop();

            }
            if (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && stack.peek() == Math.abs(asteroid)) {
                stack.pop();
                continue;
            }
            if (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0 && stack.peek() > Math.abs(asteroid)) {
                continue;
            }
            stack.push(asteroid);
        }
        int size = stack.size();
        int[] res = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
 /*
 Naive Solution: Just use the above logic but without using stack.
 Time Complexity: O(n^2)
 Space Complexity:O(1)
*/
}
