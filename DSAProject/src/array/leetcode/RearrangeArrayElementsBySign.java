package array.leetcode;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, 5, 6, 7, 8};
        int[] res = rearrangeArrayOptimal(arr);
        System.out.println("Array After Rearrangement: " + Arrays.toString(res));
    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(n)
*/
    private static int[] rearrangeArrayOptimal(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int pi = 0;
        int ni = 1;
        for (int element : arr) {
            if (element > 0) {
                result[pi] = element;
                pi += 2;
            } else {
                result[ni] = element;
                ni += 2;
            }
        }

        return result;
    }
    /*
Naive Solution:
Time Complexity: O(2*n)
Space Complexity:O(n)
*/
    private static int[] rearrangeArray(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        int i = 0;
        for (int element : arr) {
            if (element > 0) {
                result[i] = element;
                i = i + 2;
            }
        }
        i = 1;
        for (int element : arr) {
            if (element < 0) {
                result[i] = element;
                i = i + 2;
            }
        }
        return result;
    }
}
