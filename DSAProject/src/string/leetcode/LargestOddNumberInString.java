package string.leetcode;

public class LargestOddNumberInString {
    public static void main(String[] args) {
        String num = "3545";
        System.out.println("Largest Odd Number: " + largestOddNumber(num));
    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static String largestOddNumber(String num) {
        int n = num.length();
        for (int i = n - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if ((c - '0') % 2 == 1) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    /*
 Naive Solution: Find all the substrings and see which substring form the largest odd number
 Time Complexity: O(n^2)
 Space Complexity:O(1)
 */
}
