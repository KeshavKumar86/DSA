package binarysearch.gfg;

public class FindNthRootOfM {
    public static void main(String[] args) {
        int n = 3, m = 64;
        System.out.println(n + "th Root of " + m + " is " + nthRoot(n, m));
    }

    /*
Optimal Solution:
Time Complexity: O(n*logm)
Space Complexity:O(1)
*/
    private static int nthRoot(int n, int m) {
        int left = 0, right = m;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int nthPower = power(mid, n, m);
            if (nthPower == m) {
                return mid;
            }
            if (nthPower > m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
    /*
Naive Solution:
Time Complexity: O(m*n)
Space Complexity:O(1)
*/
    private static int nthRootNaive(int n, int m) {
        for (int i = 0; i <= m; i++) {
            if (m == power(i, n, m)) {
                return i;
            }
            if (m < Math.pow(i, n)) {
                break;
            }
        }
        return -1;
    }

    private static int power(int base, int exp, int limit) {
        int ans = 1;
        for (int i = 1; i <= exp; i++) {
            ans *= base;
            if (ans > limit) {
                return ans;
            }
        }
        return ans;
    }
}
