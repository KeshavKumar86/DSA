package array.learning;

import java.util.Arrays;

public class LeftRotateAnArrayBy1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original Array: " + Arrays.toString(arr));
        rotate(arr);
        System.out.println("Array after 1 Rotation: " + Arrays.toString(arr));
    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void rotate(int[] arr) {
        int n = arr.length;
        int firstElement = arr[0];
        for (int i = 1; i < n; i++) {
            arr[i - 1] = arr[i];
        }
        arr[n - 1] = firstElement;
    }
}
