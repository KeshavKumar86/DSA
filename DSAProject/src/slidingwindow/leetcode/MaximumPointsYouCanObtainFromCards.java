package slidingwindow.leetcode;

public class MaximumPointsYouCanObtainFromCards {
    public static void main(String[] args) {
        int[] arr = {9, 7, 7, 9, 7, 7, 9};
        int k = 7;
        System.out.println("Maximum Score: " + maxScoreBetter(arr, k));

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
Better Solution:
Time Complexity: O(k)
Space Complexity:O(1)
*/
    private static int maxScoreBetter(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int start = k - 1, end;
        int sum = 0, maxSum = 0;
        // first choose k from the start
        for (int i = 0; i <= start; i++) {
            sum += cardPoints[i];
        }
        maxSum = Math.max(maxSum, sum);
        // now remove 1 by one from start and add 1 by 1 from end
        for (end = 0; end < k; end++) {
            int removeIndex = k - 1 - end;
            int addIndex = n - 1 - end;
            sum = sum - cardPoints[removeIndex] + cardPoints[addIndex];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
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
