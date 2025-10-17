package string.leetcode;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strArray = {"flower", "flow", "flight"};
        System.out.println("Longest Common Prefix: " + longestCommonPrefix(strArray));
    }

    /*
 Naive Solution:
 Time Complexity: O(n*m)
 Space Complexity:O(1)
 */
    private static String longestCommonPrefixNaive(String[] strArray) {
        int n = strArray.length;
        int m = strArray[0].length();
        String startStr = strArray[0];
        for (int i = 0; i < m; i++) {
            char c = startStr.charAt(i);
            for (int j = 1; j < n; j++) {
                if (i == strArray[j].length() || strArray[j].charAt(i) != c) {
                    return startStr.substring(0, i);
                }

            }
        }
        return startStr;
    }

    /*
 Optimal Solution:
 Time Complexity: O(n*logn*m)
 Space Complexity:O(1)
 */
    private static String longestCommonPrefix(String[] strArray) {
        Arrays.sort(strArray);
        String first = strArray[0];
        String last = strArray[strArray.length - 1];
        int end = Math.min(first.length(), last.length());
        for (int i = 0; i < end; i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return first.substring(0, i);
            }
        }
        return first;
    }
    /*
 Optimal Solution:
 Time Complexity: O(n*m)
 Space Complexity:O(1)
 */
    private static String longestCommonPrefixBetter(String[] strArray) {
        String prefix = strArray[0];
        for (int i = 1; i < strArray.length; i++) {
            while (strArray[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
