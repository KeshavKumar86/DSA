package string.leetcode;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println("Is Anagram: " + isAnagram(s, t));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int n = s.length();
        int m = t.length();
        if (n != m) {
            return false;
        }
        for (int i = 0; i < n; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        System.out.println("Array: " + Arrays.toString(arr));
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
    /*
 Optimal Solution:
 Time Complexity: O(nlogn)
 Space Complexity:O(n)
 */
    private static boolean isAnagramNaive(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < s.length(); i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
