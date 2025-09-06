package array.leetcode;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {8, 5, 0, 0, 0, 45, 66, 10, 0, 20};
        System.out.println("Original Array: " + Arrays.toString(arr));
        moveZeroToEndOptimal(arr);
        System.out.println("Resulted Array: " + Arrays.toString(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void moveZeroToEndOptimal(int[] arr) {
        int nonZeroIterator = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[nonZeroIterator];
                arr[nonZeroIterator] = arr[i];
                arr[i] = temp;
                nonZeroIterator++;
            }
        }
    }

    /*
Better Solution:
Time Complexity: O(n)(2 Iteration)
Space Complexity:O(n)
*/
    private static void moveZeroToEnd(int[] arr) {
        int n = arr.length;
        int[] nonZeroArray = new int[n];
        int nonZeroIterator = 0;
        for (int element : arr) {
            if (element != 0) {
                nonZeroArray[nonZeroIterator++] = element;
            }
        }
        System.arraycopy(nonZeroArray, 0, arr, 0, n);
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static void moveZeroToEndNaive(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }
}
