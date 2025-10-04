package binarysearch.leetcode;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        System.out.println("Minimum Eating Speed: " + minEatingSpeedOptimal(piles, h));
    }

    /*
Optimal Solution:
Time Complexity: O( n*log(max(piles)) )
Space Complexity:O(1)
*/
    private static int minEatingSpeedOptimal(int[] piles, int h) {
        int left = 1, right = max(piles);
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (totalHoursReq(piles, mid) <= h) {
                res = Math.min(res, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
    /*
Naive Solution:
Time Complexity: O(n*m)
Space Complexity:O(1)
*/
    private static int minEatingSpeed(int[] piles, int h) {
        int max = max(piles);
        for (int i = 1; i <= max; i++) {
            if (totalHoursReq(piles, i) <= h) {
                return i;
            }
        }
        return max;
    }

    private static long totalHoursReq(int[] piles, int k) {
        long totalHours = 0;
        for (int pile : piles) {
            long divison = pile / k;
            if (pile % k == 0) {
                totalHours += divison;
            } else {
                totalHours += divison + 1;
            }
        }
        return totalHours;
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
