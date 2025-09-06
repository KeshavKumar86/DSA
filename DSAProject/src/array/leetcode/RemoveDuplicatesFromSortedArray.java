package array.leetcode;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println("Original Array: " + Arrays.toString(arr));
        int size = removeDuplicatesOptimal(arr);
        System.out.print("Unique Array: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int removeDuplicatesOptimal(int[] arr) {
        int n = arr.length;
        int uniqueIndex = 1;
        for (int i = 1; i < n; i++) {
            if (arr[uniqueIndex - 1] != arr[i]) {
                arr[uniqueIndex++] = arr[i];
            }
        }
        return uniqueIndex;
    }

    /*
Naive Solution:
Time Complexity: O(n)(2 iterations)
Space Complexity:O(n)
*/
    private static int removeDuplicates(int[] arr) {
        int n = arr.length;
        int[] uniqueArray = new int[n];
        uniqueArray[0] = arr[0];
        int uniqueIndex = 1;
        for (int i = 1; i < n; i++) {
            if (uniqueArray[uniqueIndex - 1] != arr[i]) {
                uniqueArray[uniqueIndex++] = arr[i];

            }
        }
        if (uniqueIndex >= 0) System.arraycopy(uniqueArray, 0, arr, 0, uniqueIndex);
        return uniqueIndex;
    }
}
