package slidingwindow.leetcode;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] arr = {4, 79, 150, 1, 1, 1, 200, 4};
        int k = 3;
        System.out.println("Maximum Score: " + maxScoreNaive(arr, k));

    }

    /*
Naive Solution:
Time Complexity: O(2^k)
Space Complexity:O(k)
*/
    private static int maxScoreNaive(int[] cardPoints, int k) {
        return helper(cardPoints, 0, cardPoints.length - 1, k);
    }

    private static int helper(int[] arr, int left, int right, int k) {
        if (k == 0) {
            return 0;
        }
        return Math.max(arr[left] + helper(arr, left + 1, right, k - 1),
                arr[right] + helper(arr, left, right - 1, k - 1));
    }

    /*
Optimal Solution:
Time Complexity: O(k)
Space Complexity:O(1)
*/
    private static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = 0, end = n - k;
        int maxScore = 0, sum = 0;
        for (int i = end; i < n; i++) {
            sum += cardPoints[i];
        }
        maxScore = Math.max(maxScore, sum);
        while (end < n) {
            sum = sum - cardPoints[end] + cardPoints[start];
            maxScore = Math.max(maxScore, sum);
            start++;
            end++;
        }
        return maxScore;
    }
}
