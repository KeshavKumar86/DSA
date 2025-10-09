package binarysearch.gfg;

public class ThePaintersPartitionProblemII {
    public static void main(String[] args) {
        int[] arr = {22, 8, 1, 11, 3, 15};
        int k=3;
        System.out.println("Minimum Time: " + minTimeNaive(arr,k));
    }
    /*
Optimal Solution:
Time Complexity: O(O(N × log(sum(arr) - max(arr))))
Space Complexity:O(1)
*/
    private static int minTime(int[] arr, int k) {
        int[] range = max_sum(arr);
        int left = range[0];
        int right = range[1];
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToPaint(arr, k, mid)) {
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
Time Complexity: O(O(N × (sum(arr) - max(arr))))
Space Complexity:O(1)
*/
    private static int minTimeNaive(int[] arr, int k) {
        int[] range = max_sum(arr);
        int start = range[0];
        int end = range[1];
        int res = end;
        for (int i = end; i >= start; i--) {
            if (!isPossibleToPaint(arr, k, i)) {
                return res;
            }
            res = i;
        }
        return start;
    }
    private static boolean isPossibleToPaint(int[] arr, int k, int maxPages) {
        int count = 0;
        int sum = 0;
        for (int element : arr) {
            sum += element;
            if (sum > maxPages) {
                count++;
                sum = element;
            }
        }
        count++;
        return count <= k;
    }

    private static int[] max_sum(int[] arr) {
        int sum = 0;
        int max = 0;
        for (int element : arr) {
            sum += element;
            max = Math.max(max, element);
        }
        return new int[]{max, sum};
    }

}
