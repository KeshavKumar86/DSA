package string.leetcode;

import java.util.*;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println("Frequency Sort: " + frequencySort(s));
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
    private static String frequencySort(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        Map<Integer, List<Character>> map = new TreeMap<>(Collections.reverseOrder());
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            freqMap.put(key, freqMap.getOrDefault(key, 0) + 1);
        }
        Set<Character> charSet = freqMap.keySet();
        for (char key : charSet) {
            int value = freqMap.get(key);
            map.computeIfAbsent(value, str -> new ArrayList<>()).add(key);
        }
        StringBuilder sb = new StringBuilder();
        Set<Integer> integerSet = map.keySet();
        for (int key : integerSet) {
            List<Character> characterList = map.get(key);
            for (Character character : characterList) {
                int freq = key;
                while (freq > 0) {
                    sb.append(character);
                    freq--;
                }
            }
        }
        return sb.toString();
    }
}
