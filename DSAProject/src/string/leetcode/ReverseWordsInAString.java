package string.leetcode;

public class ReverseWordsInAString {
    public static void main(String[] args) {
        String s = "a good   example";
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

    private static String reverseWordsOptimal(String s) {
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
}
