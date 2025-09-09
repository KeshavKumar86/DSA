package array.leetcode;

public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        int[] arr = {1, 10, 1, 9, 4, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfitOptimal2(arr));
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int maxProfit(int[] arr) {
        int n = arr.length;
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                maxProfit = Math.max(maxProfit, arr[j] - arr[i]);
            }
        }
        return maxProfit;
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int maxProfitOptimal(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int maxProfit = 0;
        int start = 0;
        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, arr[i] - arr[start]);
            if (arr[i] < arr[start]) {
                start = i;
            }
        }
        return maxProfit;
    }

    /*
Optimal Solution2:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int maxProfitOptimal2(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }
        int maxProfit = 0;
        int minValue = arr[0];
        for (int i = 1; i < n; i++) {
            maxProfit = Math.max(maxProfit, arr[i] - minValue);
            minValue = Math.min(minValue, arr[i]);
        }
        return maxProfit;
    }
}
