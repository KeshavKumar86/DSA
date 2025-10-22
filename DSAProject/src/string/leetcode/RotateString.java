package string.leetcode;

public class RotateString {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "cdeab";
        System.out.println("Is Rotate String: " + rotateStringNaive(s, t));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        s = s + s;
        return s.contains(goal);
    }
    /*
 Naive Solution:
 Time Complexity: O(n^2)
 Space Complexity:O(n^2)
 */
    private static boolean rotateStringNaive(String s, String goal) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(0);
            s = s.substring(1) + c;
            if (s.equals(goal)) {
                return true;
            }
        }
        return false;
    }
}
