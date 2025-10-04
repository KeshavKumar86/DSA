package binarysearch.leetcode;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
        int[] arr = {1, 10, 3, 10, 2};
        int m = 3, k = 1;
        System.out.println("Minimum Days: " + minDaysOptimal(arr, m, k));
    }

    /*
Optimal Solution:
Time Complexity: O( n*log(max(bloomDay) - min(bloomDay)) )
Space Complexity:O(1)
*/
    private static int minDaysOptimal(int[] bloomDay, int m, int k) {
        int left = min_max(bloomDay)[0];
        int right = min_max(bloomDay)[1];
        int res = right;
        boolean isAnsPossible = false;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossible(bloomDay, m, k, mid)) {
                res = Math.min(res, mid);
                isAnsPossible = true;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (isAnsPossible) {
            return res;
        }
        return -1;
    }

    /*
Naive Solution:
Time Complexity: O( n*max(bloomDay) - min(bloomDay) )
Space Complexity:O(1)
*/
    private static int minDays(int[] bloomDay, int m, int k) {
        int min = min_max(bloomDay)[0];
        int max = min_max(bloomDay)[1];
        for (int i = min; i <= max; i++) {
            if (isPossible(bloomDay, m, k, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean isPossible(int[] arr, int m, int k, int days) {
        int count = 0;
        for (int element : arr) {
            if (element <= days) {
                count++;
            } else {
                count = 0;
            }
            if (count == k) {
                m--;
                count = 0;
            }
        }
        return m <= 0;
    }

    private static int[] min_max(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        return new int[]{min, max};
    }

}
