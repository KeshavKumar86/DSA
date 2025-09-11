package array.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {4,1, 3, 3};
        System.out.println("Original Array: " + Arrays.toString(arr));
        nextPermutationOptimal(arr);
        System.out.println("Next Permutation: " + Arrays.toString(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void nextPermutationOptimal(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                int index = nextGreater(arr, i - 1, n - 1, arr[i - 1]);
                //swap i-1 and next greater
                int temp = arr[i - 1];
                arr[i - 1] = arr[index];
                arr[index] = temp;
                reverse(arr, i, n - 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            reverse(arr, 0, n - 1);
        }
    }

    private static void reverse(int[] arr, int a, int b) {
        int low = a;
        int high = b;
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
Time Complexity: O(n*Logn)
Space Complexity:O(n)
*/
    private static void nextPermutation(int[] arr) {
        int n = arr.length;
        boolean flag = false;
        for (int i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                int index = nextGreater(arr, i - 1, n - 1, arr[i - 1]);
                //swap i-1 and next greater
                int temp = arr[i - 1];
                arr[i - 1] = arr[index];
                arr[index] = temp;
                partSort(arr, i, n - 1);
                flag = true;
                break;
            }
        }
        if (!flag) {
            partSort(arr, 0, n - 1);
        }
    }

    private static int nextGreater(int[] arr, int start, int end, int element) {
        int nextGreaterIndex = end;
        int nextGreater = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            if (arr[i] > element) {
                if (arr[i] <= nextGreater) {
                    nextGreater = arr[i];
                    nextGreaterIndex = i;
                }
            }
        }
        return nextGreaterIndex;
    }

    private static void partSort(int[] arr, int a, int b) {
        int l = Math.min(a, b);
        int r = Math.max(a, b);
        int[] temp = new int[r - l + 1];
        int j = 0;
        for (int i = l; i <= r; i++) {
            temp[j] = arr[i];
            j++;
        }
        Arrays.sort(temp);
        j = 0;
        for (int i = l; i <= r; i++) {
            arr[i] = temp[j];
            j++;
        }
    }
}
