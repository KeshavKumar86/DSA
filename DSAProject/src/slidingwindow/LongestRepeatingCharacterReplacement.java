package slidingwindow;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Maximum Length Substring: " + characterReplacement(s, k));
    }
    /*
Optimal Solution:
Time Complexity: O(2*n)
Space Complexity:O(26)
*/
    private static int characterReplacement(String s, int k) {
        int n = s.length();
        int[] freq = new int[26];
        int start = 0, end;
        int maxLength = 0;
        int maxFreq = 0;
        for (end = 0; end < n; end++) {
            freq[s.charAt(end) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(end) - 'A']);
            while ((end - start + 1) - maxFreq > k) {
                //shrink the window
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, (end - start + 1));
        }
        return maxLength;
    }
}
