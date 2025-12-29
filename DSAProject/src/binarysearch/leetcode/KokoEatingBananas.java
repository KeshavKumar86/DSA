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
            if (isPossible(piles, mid, h)) {
                res = mid;
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
            if (isPossible(piles, i, h)) {
                return i;
            }
        }
        return max;
    }

    private static boolean isPossible(int[] piles, int speed, int expectedHours) {
        // long is mandatory otherwise overflow will happen
        long totalHours = 0;
        for (int pile : piles) {
            int num = pile / speed;
            if (pile % speed == 0) {
                totalHours += num;
            } else {
                totalHours += (num + 1);
            }

        }
        return totalHours <= expectedHours;
    }

    private static int max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        return max;
    }
}
