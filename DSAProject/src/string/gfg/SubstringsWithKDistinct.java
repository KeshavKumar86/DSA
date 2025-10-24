package string.gfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SubstringsWithKDistinct {
    public static void main(String[] args) {
        String s = "aabb";
        int k = 2;
        System.out.println("Total Substrings: " + countSubstrNaive(s, k));

    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(k)
 */
    private static int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private static int atMostK(String s, int k) {
        int n = s.length();
        int count = 0;
        int start = 0, end;
        Map<Character, Integer> map = new HashMap<>();
        for (end = 0; end < n; end++) {
            char key = s.charAt(end);
            map.put(key, map.getOrDefault(key, 0) + 1);
            while (map.size() > k) {
                int freq = map.get(s.charAt(start));
                if (freq > 1) {
                    map.put(s.charAt(start), freq - 1);
                } else {
                    map.remove(s.charAt(start));
                }
                start++;
            }
            int windowSize = end - start + 1;
            count += windowSize;
        }
        return count;
    }
    /*
 Optimal Solution:
 Time Complexity: O(n^2)
 Space Complexity:O(k)
 */
    private static int countSubstrNaive(String s, int k) {
        int n = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() > k) {
                    break;
                }
                if (set.size() == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
