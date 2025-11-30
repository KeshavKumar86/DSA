package stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1764523";
        int k = 4;
        System.out.println("Result: " + removeKdigits(num, k));
    }

    /*
     Optimal Solution:
     Time Complexity: O(n)
     Space Complexity:O(n)
    */
    private static String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                while (!stack.isEmpty() && stack.peek() > (num.charAt(i) - '0') && k > 0) {
                    stack.pop();
                    k--;
                }
            }
            stack.push(num.charAt(i) - '0');
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        // if k is not zero remove k digits
        res = new StringBuilder(res.substring(k));
        res.reverse();
        int length = res.length();
        int i;
        //remove leading zeros
        for (i = 0; i < length; i++) {
            if (res.charAt(i) != '0') {
                break;
            }
        }
        String result = res.substring(i);
        //if all digits removed then return 0
        if (result.isEmpty()) {
            return "0";
        }
        return result;
    }
}
