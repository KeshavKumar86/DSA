package string.leetcode;

public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println("Maximum Nesting Depth: " + maxDepth(s));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static int maxDepth(String s) {
        int maxCount = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                maxCount = Math.max(maxCount, count);
            }
            else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return maxCount;
    }
}
