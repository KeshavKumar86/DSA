package binarysearch.leetcode;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 7, 11};
        int k = 5;
        System.out.println(k + "th Missing Number: " + findKthPositive(arr, k));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (totalMissingAtIndex(arr, mid) < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == 0) {
            return k;
        }
        return arr[right] + k - totalMissingAtIndex(arr, right);
    }

    private static int totalMissingAtIndex(int[] arr, int index) {
        return arr[index] - 1 - index;
    }

    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int findKthPositiveNaive(int[] arr, int k) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int totalMissing = arr[i] - 1 - i;
            if (totalMissing >= k) {
                if (i == 0) {
                    return k;
                }
                int prevMissing = arr[i - 1] - i;
                return arr[i - 1] + k - prevMissing;
            }
        }
        int missingTillEnd = arr[n - 1] - n;
        return arr[n - 1] + k - missingTillEnd;
    }
}
