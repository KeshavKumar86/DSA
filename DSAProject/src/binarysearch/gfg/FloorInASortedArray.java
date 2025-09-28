package binarysearch.gfg;

public class FloorInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int target = 0;
        System.out.println("Floor's Index: " + findFloorNaive(arr, target));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int findFloor(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > x) {
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
    private static int findFloorNaive(int[] arr, int x) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > x) {
                return i - 1;
            }
        }
        return n - 1;
    }
}
