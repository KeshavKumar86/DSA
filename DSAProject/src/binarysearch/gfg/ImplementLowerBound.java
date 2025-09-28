package binarysearch.gfg;

public class ImplementLowerBound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 25};
        int target = 30;
        System.out.println("Element's Index: " + lowerBoundNaive(arr,target));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int lowerBound(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }
    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int lowerBoundNaive(int[] arr, int target) {
        int n = arr.length;
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }
        return i;
    }
}
