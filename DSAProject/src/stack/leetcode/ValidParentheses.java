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
            } else {
                if (stack.empty()) {
                    return false;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return false;
                }
                if (c == ']' && top != '[') {
                    return false;
                }
                if (c == '}' && top != '{') {
                    return false;
                }
            }

        }
        return stack.empty();
    }

    /*
       Optimal Solution:
       Time Complexity: O(n)
       Space Complexity: O(n)
       */
    private static boolean isValidStandard(String s) {
        int length = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                if (stack.empty() || stack.pop() != s.charAt(i)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
