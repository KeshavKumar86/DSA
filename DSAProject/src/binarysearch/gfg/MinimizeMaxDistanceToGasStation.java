package binarysearch.gfg;

public class MinimizeMaxDistanceToGasStation {
    public static void main(String[] args) {
        int[] arr = {3, 6, 12, 19, 33};
        int k = 3;
        System.out.println("Minimum Distance Possible: " + minMaxDist(arr, k));
    }

    /*
Optimal Solution:
Time Complexity: O(n × log₂(maxGap / precision))
Space Complexity:O(1)
*/
    private static double minMaxDist(int[] stations, int k) {
        double low = 0;
        double high = 0;
        for (int i = 1; i < stations.length; i++) {
            high = Math.max(high, stations[i] - stations[i - 1]);
        }
        double res = high;
        while (high - low > 1e-6) {
            double mid = low + (high - low) / 2.0;
            if (isPossibleToAllocate(stations, k, mid)) {
                res = mid;
                high = mid;
            } else {
                low = mid;
            }
        }
        return Math.round(res * 100.0) / 100.0;
    }

    private static boolean isPossibleToAllocate(int[] arr, int k, double dis) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            double gap = arr[i] - arr[i - 1];
            int needed = (int) (gap / dis);
            if (Math.abs(gap % dis) < 1e-9) { // to handle floating-point precision
                needed--; // one less if perfectly divisible
            }
            count += needed;
            if (count > k) return false; // small optimization
        }
        return count <= k;
    }
        /*
Naive Solution: theoretically, this can be done with linear search, but in practice it’s
extremely inefficient
The idea:
Compute the maximum gap between consecutive stations (maxGap).
Try every possible distance d from some small value up to maxGap (e.g., in steps of 0.01).
For each d, check if it’s possible to place k or fewer stations so that no gap exceeds d
(using the same isPossible() logic).
Return the smallest feasible d.
*/
}
