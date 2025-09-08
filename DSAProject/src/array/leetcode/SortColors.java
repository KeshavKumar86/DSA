package array.leetcode;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] arr = {2, 0, 2, 1, 1, 0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        sortColorsBetter(arr);
        System.out.println("Array After Sorting: " + Arrays.toString(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void sortColorsOptimal(int[] arr) {
        int i = 0, j = 0;
        int k = arr.length - 1;
        while (j <= k) {
            if (arr[j] == 0) {
                arr[j] = arr[i];
                arr[i] = 0;
                i++;
                j++;
            } else if (arr[j] == 2) {
                arr[j] = arr[k];
                arr[k] = 2;
                k--;
            } else
                j++;
        }
    }

    /*
Better Solution:
Time Complexity: O(2*n)
Space Complexity:O(1)
     */
    private static void sortColorsBetter(int[] arr) {
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        for (int element : arr) {
            if (element == 0) {
                zeroCount++;
            } else if (element == 1) {
                oneCount++;
            } else {
                twoCount++;
            }
        }
        int i = 0;
        while (zeroCount > 0) {
            arr[i++] = 0;
            zeroCount--;
        }
        while (oneCount > 0) {
            arr[i++] = 1;
            oneCount--;
        }
        while (twoCount > 0) {
            arr[i++] = 2;
            twoCount--;
        }
    }

    /*
Naive Solution:
Time Complexity: O(n*logn)
Space Complexity:O(1)
     */
    private static void sortColors(int[] arr) {
        Arrays.sort(arr);
    }
}
