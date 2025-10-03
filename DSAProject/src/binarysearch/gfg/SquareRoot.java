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
        // code here
        int left = 0, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long square = (long) mid * mid;
            if (square == n) {
                return mid;
            }
            if (square > n) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int floorSqrt(int n) {
        // code here
        if (n == 1) {
            return 1;
        }
        int i;
        for (i = 1; i < n / 2 + 1; i++) {
            if (i * i == n) {
                return i;
            } else if (i * i > n) {
                return i - 1;
            }
        }
        return i - 1;
    }
}
