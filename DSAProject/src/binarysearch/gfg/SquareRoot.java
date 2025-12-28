package binarysearch.gfg;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 101;
        System.out.println("Square Root of " + n + " is: " + floorSqrtOptimal(n));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int floorSqrtOptimal(int n) {
        int left = 0, right = n;
        int ans = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square <= n) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int floorSqrt(int n) {
        int num = 1;
        while (num * num < n) {
            num++;
        }
        if (num * num == n) {
            return num;
        }
        return num - 1;
    }
}
