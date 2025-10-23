package string.leetcode;

import java.util.Map;

public class RomanToInteger {
    public static void main(String[] args) {
        String s = "CMXCIV";
        System.out.println("Roman To Integer: " + romanToInt(s));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static int romanToInt(String s) {
        Map<Character, Integer> map = Map.of('I', 1,
                'V', 5, 'X', 10, 'L', 50, 'C', 100,
                'D', 500, 'M', 1000);
        int n = s.length();
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n && map.get(s.charAt(i + 1)) > map.get(s.charAt(i))) {
                res -= map.get(s.charAt(i));
            } else {
                res += map.get(s.charAt(i));
            }
        }
        return res;
    }
}
