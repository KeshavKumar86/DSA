package array.learning;

import java.util.Arrays;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 20, 8};
        int largestIndex = largestOptimal(arr);
        System.out.println("Largest Element: " + arr[largestIndex]);
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int largestOptimal(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        return index;
    }

    /*
Naive Solution:
Time Complexity: O(n*logn)
Space Complexity:O(1)
*/
    private static int largest(int[] arr) {
        Arrays.sort(arr);
        return arr.length - 1;
    }
}

