package array.leetcode;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, -4, 2, 4, 6, -8, 10, 12, 4, -6};
        System.out.println("Maximum Product: " + maxProduct(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int maxProductOptimal(int[] nums) {
        int n = nums.length;
        int prefixProduct = 1, suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (prefixProduct == 0) {
                prefixProduct = 1;
            }
            if (suffixProduct == 0) {
                suffixProduct = 1;
            }
            prefixProduct *= nums[i];
            suffixProduct *= nums[n - 1 - i];
            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }
        return maxProduct;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int currProduct = 1;
            for (int j = i; j < n; j++) {
                currProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currProduct);
            }
        }
        return maxProduct;
    }
}
