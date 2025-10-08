package binarysearch.leetcode;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        System.out.println("Minimum Largest Pages: " + splitArray(arr, k));
    }
    /*
Optimal Solution:
Time Complexity: O(O(N × log(sum(arr) - max(arr))))
Space Complexity:O(1)
*/
    private static int splitArray(int[] nums, int k) {
        int[] range = max_sum(nums);
        int left = range[0];
        int right = range[1];
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToSplit(nums, k, mid)) {
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
    private static int splitArrayNaive(int[] nums, int k) {
        if (k > nums.length) {
            return -1;
        }
        int[] range = max_sum(nums);
        int first = range[0];
        int last = range[1];
        for (int i = last; i >= first; i--) {
            if (!isPossibleToSplit(nums, k, i)) {
                return i + 1;
            }
        }
        return first;
    }

    private static boolean isPossibleToSplit(int[] arr, int k, int maxPages) {
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
