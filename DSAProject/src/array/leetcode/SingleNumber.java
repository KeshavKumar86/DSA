package array.leetcode;

import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 1, 2};
        System.out.println("Single Number: " + singleNumber(arr));
    }

    /*
Better Solution:
Time Complexity: O(n*logn)
Space Complexity:O(1)
*/
    private static int singleNumberBetter(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i = i + 2) {
            if (arr[i] != arr[i + 1]) {
                return arr[i];
            }

        }
        return arr[n - 1];
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int singleNumber(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean flag = false;
            for (int j = 0; j < arr.length; j++) {
                if (i != j && arr[i] == arr[j]) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return arr[i];
            }
        }
        return -1;
    }
}
