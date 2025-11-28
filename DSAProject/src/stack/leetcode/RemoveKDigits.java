package stack.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println("Result: " + removeKdigits(num, k));
    }

    private static String removeKdigits(String num, int k) {
        int n = num.length();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (k > 0) {
                if (!stack.isEmpty()) {
                    if (stack.peek() > (num.charAt(i) - '0')) {
                        stack.pop();
                        k--;
                    }
                }
            }
            stack.push(num.charAt(i) - '0');
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        res = new StringBuilder(res.substring(k));
        res.reverse();
        int length = res.length();
        int i;
        for (i = 0; i < length; i++) {
            if (res.charAt(i) != '0') {
                break;
            }
        }
        String result = res.substring(i);
        if (result.isEmpty()) {
            return "0";
        }
        return result;
    }
}
