package array.gfg;

import java.util.ArrayList;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int[] arr = {1, 1};
        System.out.println("Missing and Repeating Number: " + findTwoElement(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;
        long actualSum = (long) n * (n + 1) / 2;
        long actualSquaresSum = n * (n + 1) * (2L * n + 1) / 6;
        return null;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static ArrayList<Integer> findTwoElementNaive(int[] arr) {
        int n = arr.length;
        int duplicate = 0;
        int missing = 0;
        for (int i = 1; i <= n; i++) {
            int freq = 0;
            for (int element : arr) {
                if (i == element) {
                    freq++;
                }
            }
            if (freq == 2) {
                duplicate = i;
            }
            if (freq == 0) {
                missing = i;
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        result.add(duplicate);
        result.add(missing);
        return result;
    }

}
