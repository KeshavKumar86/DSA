package slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// This is same questions as Longest subarray with At most two distinct integers of GFG
public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] arr = {11, 7, 11, 10, 10, 15};
        System.out.println("Total Fruits: " + totalFruit(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int totalFruitOptimal(int[] fruits) {
        int n = fruits.length;
        int maxLength = 0;
        int start = 0, end;
        Map<Integer, Integer> map = new HashMap<>();
        for (end = 0; end < n; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            while (map.size() > 2) {
                int freq = map.get(fruits[start]);
                if (freq == 1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], freq - 1);
                }
                start++;
            }
            int windowSize = end - start + 1;
            maxLength = Math.max(maxLength, windowSize);
        }
        return maxLength;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int totalFruit(int[] fruits) {
        int n = fruits.length;
        int maxFruits = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.clear();
            for (int j = i; j < n; j++) {
                set.add(fruits[j]);
                if (set.size() > 2) {
                    break;
                }
                int windowSize = j - i + 1;
                maxFruits = Math.max(maxFruits, windowSize);
            }
        }
        return maxFruits;
    }
}
