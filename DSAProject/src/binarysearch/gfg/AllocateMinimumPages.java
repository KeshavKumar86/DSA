package binarysearch.gfg;

public class AllocateMinimumPages {
    public static void main(String[] args) {
        int[] arr = {15, 10, 19, 10, 5, 18, 7};
        int k = 5;
        System.out.println("Minimum Pages Possible: " + findPages(arr, k));
    }

    /*
Optimal Solution:
Time Complexity: O(O(N × log(sum(arr) - max(arr))))
Space Complexity:O(1)
*/
    private static int findPages(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        int[] range = max_sum(arr);
        int left = range[0];
        int right = range[1];
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isPossibleToAllocate(arr, k, mid)) {
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
    private static int findPagesNaive(int[] arr, int k) {
        if (k > arr.length) {
            return -1;
        }
        int[] range = max_sum(arr);
        int first = range[0];
        int last = range[1];
        for (int i = last; i >= first; i--) {
            if (!isPossibleToAllocate(arr, k, i)) {
                return i + 1;
            }
        }
        return first;
    }

    private static boolean isPossibleToAllocate(int[] arr, int k, int maxPages) {
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
