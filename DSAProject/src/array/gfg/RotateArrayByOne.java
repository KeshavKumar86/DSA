package array.gfg;

import java.util.Arrays;

public class RotateArrayByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        rotate(arr);
        System.out.println("Array After Rotation: " + Arrays.toString(arr));
    }
    /*
        Optimal Solution:
        Time Complexity: O(n)
        Space Complexity:O(1)
       */
    private static void rotate(int[] arr) {
        int n = arr.length;
        int lastElement = arr[n - 1];
        for (int i = n-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = lastElement;
    }
}
