package slidingwindow.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcgbedf";
        System.out.println("Length of Longest Substring: " + lengthOfLongestSubstringOptimal2(s));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int lengthOfLongestSubstringOptimal(String s) {
        int n = s.length();
        int start = 0, end ;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for (end = 0; end < n; end++) {
            while (set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
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
    private static int lengthOfLongestSubstringOptimal2(String s) {
        int n = s.length();
        int start = 0, end;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (end = 0; end < n; end++) {
            char key = s.charAt(end);
            if (map.containsKey(key) && map.get(key) >= start) {
                int index = map.get(key);
                start = index + 1;
            }
            map.put(key, end);
            int windowSize = (end - start + 1);
            max = Math.max(max, windowSize);
        }
        return max;
    }

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
