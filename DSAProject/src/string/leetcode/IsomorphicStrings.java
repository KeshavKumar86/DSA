package string.leetcode;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static void main(String[] args) {
        String s = "bada", t = "baba";
        System.out.println("Is " + s + " and " + t + " are Isomorphic: " + isIsomorphic(s, t));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char key1 = s.charAt(i);
            char key2 = t.charAt(i);
            if (mapST.containsKey(key1) && mapST.get(key1) != t.charAt(i)) {
                return false;
            }
            if (mapTS.containsKey(key2) && mapTS.get(key2) != s.charAt(i)) {
                return false;
            }
            mapST.put(key1, t.charAt(i));
            mapTS.put(key2, s.charAt(i));
        }
        return true;
    }
    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    public boolean isIsomorphicNaive(String s, String t) {
        return isIsomorphicOneWayNaive(s, t) && isIsomorphicOneWayNaive(t, s);
    }

    public boolean isIsomorphicOneWayNaive(String s, String t) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            for (int j = i; j < n; j++) {
                if (s.charAt(j) == c) {
                    if (!(t.charAt(j) == t.charAt(i))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
