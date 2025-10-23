package string.leetcode;

public class StringToInteger {
    public static void main(String[] args) {
        String s = "+1";
        System.out.println("Integer Value: " + myAtoi(s));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static int myAtoi(String s) {
        s = s.trim();
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        long result = 0;
        boolean isNegative = false;
        int i = 0;
        if (s.charAt(0) == '-') {
            isNegative = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }
        while (i < n && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            result = result * 10 + (s.charAt(i) - '0');
            if (!isNegative && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (isNegative && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        if (isNegative) {
            result = -result;
        }
        return (int) result;
    }
}
