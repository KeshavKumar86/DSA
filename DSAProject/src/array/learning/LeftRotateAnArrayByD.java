package array.learning;

import java.util.Arrays;

public class LeftRotateAnArrayByD {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 8;
        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateDPlacesOptimal(arr, d);
        System.out.println("Array After " + d + " Rotation: " + Arrays.toString(arr));
    }

    /*
Optimal Solution: Reversal Algorithm
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void rotateDPlacesOptimal(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    private static void reverse(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }
    }

    /*
Better Solution:
Time Complexity: O(n)
Space Complexity:O(d)
*/
    private static void rotateDPlaces2(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        int[] tempArray = new int[d];
        System.arraycopy(arr, 0, tempArray, 0, d);
        for (int i = d; i < n; i++) {
            arr[i - d] = arr[i];
        }
        System.arraycopy(tempArray, 0, arr, n - d, d);
    }

    /*
Naive Solution:
Time Complexity: O(n*d)
Space Complexity:O(1)
*/
    private static void rotateDPlaces(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        for (int i = 0; i < d; i++) {
            rotate(arr);
        }
    }

    private static void rotate(int[] arr) {
        int n = arr.length;
        int firstElement = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = firstElement;
    }
}
