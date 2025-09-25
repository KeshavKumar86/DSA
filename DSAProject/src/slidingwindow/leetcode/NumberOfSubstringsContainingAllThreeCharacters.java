package slidingwindow.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfSubstringsContainingAllThreeCharacters {
    public static void main(String[] args) {
        String s = "aaacb";
        System.out.println("Total Substring: " + numberOfSubstringsNaive(s));

    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int numberOfSubstrings(String s) {
        int n = s.length();
        int start = 0, end;
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (end = 0; end < n; end++) {
            Character key = s.charAt(end);
            map.put(key, map.getOrDefault(key, 0) + 1);
            while (map.size() == 3) {
                count += n - end;
                if (map.get(s.charAt(start)) == 1) {
                    map.remove(s.charAt(start));
                } else {
                    map.put(s.charAt(start), map.get(s.charAt(start)) - 1);
                }
                start++;
            }
        }
        return count;
    }
    /*
Optimal Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int numberOfSubstringsNaive(String s) {
        int n = s.length();
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            set.clear();
            for(int j =i;j<n;j++){
                set.add(s.charAt(j));
                if(set.size()==3){
                    count += n - j;
                    break;
                }
            }
        }
        return count;
    }
}
