package binarysearch.gfg;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {2, 12, 11, 3, 26, 7};
        int k = 5;
        System.out.println("Minimum Distance: " + aggressiveCows(arr, k));
    }

    /*
Optimal Solution:
Time Complexity: O(nlogn + nlog(max(arr)-min(arr))
Space Complexity:O(1)
*/
    private static int aggressiveCows(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int left = 1, right = stalls[n - 1] - stalls[0];
        int res = left;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(stalls, k, mid)) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    /*
Optimal Solution:
Time Complexity: O(nlogn + n*(max(arr)-min(arr))
Space Complexity:O(1)
*/
    private static int aggressiveCowsNaive(int[] stalls, int k) {
        int n = stalls.length;
        Arrays.sort(stalls);
        int min = 1, max = stalls[n - 1] - stalls[0];
        for (int i = min; i <= max; i++) {
            if (!isPossible(stalls, k, i)) {
                return i - 1;
            }
        }
        return max;
    }

    private static boolean isPossible(int[] arr, int k, int minDistance) {
        int n = arr.length;
        int prevIndex = 0;
        k--;
        for (int i = 1; i < n; i++) {
            if (arr[i] - arr[prevIndex] >= minDistance) {
                prevIndex = i;
                k--;
                if (k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
