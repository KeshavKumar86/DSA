package array.learning;

import java.util.Arrays;

public class ReverseAnArray {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 45, 23, 32, 40, 50};
        reverseOptimal(arr);
        System.out.println("Reversal of Array: " + Arrays.toString(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void reverseOptimal(int[] arr) {
        int low = 0, high = arr.length - 1;
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    /*
Naive Solution:
Time Complexity: O(n)(2 iterations)
Space Complexity:O(n)
*/
    private static void reverse(int[] arr) {
        int n = arr.length;
        int[] tempArray = new int[n];
        int low = 0, high = n - 1;
        while (high >= 0) {
            tempArray[low] = arr[high];
            low++;
            high--;
        }
        System.arraycopy(tempArray, 0, arr, 0, n);
    }
}
