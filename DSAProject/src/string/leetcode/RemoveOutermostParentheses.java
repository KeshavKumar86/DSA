package string.leetcode;

public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        String s = "()()";
        System.out.println("Output String: " + removeOuterParentheses(s));

    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                if (count >= 1) {
                    sb.append('(');
                }
                count++;
            } else {
                if (count != 1) {
                    sb.append(')');
                }
                count--;
            }
        }
        return sb.toString();
    }
}
