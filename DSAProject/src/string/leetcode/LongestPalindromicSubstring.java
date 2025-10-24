package string.leetcode;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String s = "bbbbbb";
        System.out.println("Longest Palindromic Substring: " + longestPalindrome(s));
    }

    /*
 Optimal Solution:
 Time Complexity: O(n^2)
 Space Complexity:O(1)
 */
    private static String longestPalindrome(String s) {
        int maxLength = 1;
        int startIndex = 0;
        int endIndex = 0;
        int left, right;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            //for odd length
            left = i;
            right = i;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    startIndex = left;
                    endIndex = right;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }
            //for even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > maxLength) {
                    startIndex = left;
                    endIndex = right;
                    maxLength = right - left + 1;
                }
                left--;
                right++;
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    /*
 Optimal Solution:
 Time Complexity: O(n^3)
 Space Complexity:O(1)
 */
    private static String longestPalindromeNaive(String s) {
        int maxLength = 1;
        int n = s.length();
        int startIndex = 0;
        int endIndex = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + maxLength; j < n; j++) {
                if (isPalindrome(s.substring(i, j + 1))) {
                    maxLength = j - i + 1;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }
        return s.substring(startIndex, endIndex + 1);
    }

    private static boolean isPalindrome(String s) {
        int n = s.length();
        int start = 0, end = n - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
