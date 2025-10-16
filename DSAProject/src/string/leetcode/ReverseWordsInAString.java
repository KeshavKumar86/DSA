package string.leetcode;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "    a     good   example    ";
        System.out.println("Reverse Words String: " + reverseWordsOptimal(s));
    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static String reverseWordsBetter(String s) {
        s = s.trim();
        String[] arr = s.split("\\s+");
        int n = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(arr[i]);
            if (i != 0) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static String reverseWordsOptimal(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        int end = s.length() - 1, start = 0;
        boolean isWord = false;
        boolean firstWordAdded = false;
        for (int i = end; i >= start; i--) {
            if (s.charAt(i) != ' ') {
                isWord = true;
                sb.append(s.charAt(i));
            } else {
                if (isWord) {
                    if (firstWordAdded) {
                        result.append(' ');
                    }
                    firstWordAdded = true;
                    result.append(sb.reverse());
                    sb.setLength(0);
                    isWord = false;
                }
            }
        }
        if (isWord) {
            if (firstWordAdded) {
                result.append(' ');
            }
            result.append(sb.reverse());
        }
        if (result.charAt(result.length() - 1) == ' ') {
            result.deleteCharAt(result.length() - 1);
        }
        return result.toString();
    }
}
