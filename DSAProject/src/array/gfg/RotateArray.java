package array.gfg;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int d = 2;
        rotateArr(arr, d);
        System.out.println("Array After Rotation: " + Arrays.toString(arr));
    }
    /*
            Optimal Solution:
            Time Complexity: O(n)
            Space Complexity:O(1)
           */
    static void rotateArr(int[] arr, int d) {
        int n = arr.length;
        d = d % n;
        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    /*
            Better Solution:
            Time Complexity: O(n)
            Space Complexity:O(d)
           */
    /*
            Naive Solution:
            Time Complexity: O(n*d)
            Space Complexity:O(1)
           */
}
