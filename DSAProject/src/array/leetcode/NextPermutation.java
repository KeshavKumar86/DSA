package array.leetcode;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println("Original Array: " + Arrays.toString(arr));
        nextPermutationOptimal(arr);
        System.out.println("Next Permutation: " + Arrays.toString(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static void nextPermutationOptimal(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // 1. Find pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }
        // 2. If no pivot, reverse whole array
        if (pivot == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // 3. Find next greater element
        int nextGreaterIndex = pivot + 1;
        for (int i = nextGreaterIndex + 1; i < n; i++) {
            if (nums[i] > nums[pivot] && nums[i] <= nums[nextGreaterIndex]) {
                nextGreaterIndex = i;
            }
        }
        // 4. swap next greater and pivot
        int temp = nums[pivot];
        nums[pivot] = nums[nextGreaterIndex];
        nums[nextGreaterIndex] = temp;
        // 5. Reverse the suffix to get the smallest lexicographical order
        reverse(nums, pivot + 1, n - 1);
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
    private static void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = -1;
        // 1. Find pivot
        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                pivot = i - 1;
                break;
            }
        }
        // 2. If no pivot, reverse whole array
        if (pivot == -1) {
            partSort(nums, 0, n - 1);
            return;
        }
        // 3. Find next greater element
        int nextGreaterIndex = pivot + 1;
        for (int i = nextGreaterIndex + 1; i < n; i++) {
            if (nums[i] > nums[pivot] && nums[i] <= nums[nextGreaterIndex]) {
                nextGreaterIndex = i;
            }
        }
        // 4. swap next greater and pivot
        int temp = nums[pivot];
        nums[pivot] = nums[nextGreaterIndex];
        nums[nextGreaterIndex] = temp;
        // 5. Sort the subarray
        partSort(nums, pivot + 1, n - 1);
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
        /*
Naive Solution: 1.Generate all permutations
                2.Sort all the permutations
                2.Do Linear Search
                3.find the next permutations
Time Complexity: O(n × n! + n × n! log(n!))≈ O(n × n! log(n!))
Space Complexity:O(n!*n)
*/
}
