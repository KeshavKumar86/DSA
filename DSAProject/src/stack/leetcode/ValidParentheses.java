package stack.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "([)]";
        System.out.println("Is Valid Parenthesis: " + isValid(s));
    }

    /*
    Optimal Solution:
    Time Complexity: O(n)
    Space Complexity: O(n)
    */
    private static boolean isValid(String s) {
        int length = s.length();
        if (length % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
            if (c == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    return false;
                }
                stack.pop();
            }
            if (c == '}') {
                if (stack.empty() || stack.peek() != '{') {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.empty();
    }
}
