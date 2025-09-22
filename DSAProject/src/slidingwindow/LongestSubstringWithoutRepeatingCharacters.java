package slidingwindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcdefbghi";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstring(s));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int lengthOfLongestSubstringOptimal(String s) {
        int n = s.length();
        int max = 0;
        int start = 0, end;
        Set<Character> set = new HashSet<>();
        for (end = 0; end < n; end++) {
            if (set.contains(s.charAt(end))) {
                while (set.contains(s.charAt(end))) {
                    set.remove(s.charAt(start++));
                }
            }
            set.add(s.charAt(end));
            max = Math.max(max, set.size());

        }
        return max;
    }

    /*
Optimal Solution2: We can use hashmap and instead of iterating the start to till we have duplicate
we can directly get the index of the duplicate using map and directly calculate the max length.
Time Complexity: O(n)
Space Complexity:O(n)
*/
    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(n)
*/
    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                if (set.contains(s.charAt(j))) {
                    break;
                }
                set.add(s.charAt(j));
                maxLength = Math.max(maxLength, set.size());
            }
        }
        return maxLength;
    }
}
