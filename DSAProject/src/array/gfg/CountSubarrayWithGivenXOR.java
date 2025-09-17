package array.gfg;

import java.util.HashMap;
import java.util.Map;

public class CountSubarrayWithGivenXOR {
    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9};
        int k = 9;
        System.out.println("Total Subarray with xor " + k + " is: " + subarrayXorNaive(arr, k));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static long subarrayXor(int[] arr, int k) {
        long count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixXor = 0;
        map.put(0, 1);
        for (int element : arr) {
            prefixXor = prefixXor ^ element;
            int key = prefixXor ^ k;
            if (map.containsKey(key)) {
                count += map.get(key);
            }
            map.put(prefixXor, map.getOrDefault(prefixXor, 0) + 1);
        }
        return count;
    }

    /*
Naive Solution: Generate all sub arrays and calculate their xor if equal to k count that.
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static long subarrayXorNaive(int[] arr, int k) {
        int n = arr.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            int xor = 0;
            for (int j = i; j < n; j++) {
                xor = xor ^ arr[j];
                if (xor == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
