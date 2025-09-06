package array.leetcode;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 0;
        System.out.println("Original Array: " + Arrays.toString(arr));
        rotateOptimal(arr, k);
        System.out.println("Rotated Array: " + Arrays.toString(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void rotateOptimal(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        reverse(arr, 0, n - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, n - 1);
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
Naive Solution:
Time Complexity: O(n*k)
Space Complexity:O(1)
*/
    private static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;
        for (int i = 0; i < k; i++) {
            rotateRightBy1(arr);
        }
    }

    private static void rotateRightBy1(int[] arr) {
        int n = arr.length;
        int lastElement = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i + 1] = arr[i];
        }
        arr[0] = lastElement;
    }
    /*
    Solution3: We can store last k  elements then move every element to its right by k places, and
    then put those k elements at the start
    Time Complexity: O(n)
    Space Complexity: O(k)
     */
}
