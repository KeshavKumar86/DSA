package binarysearch.gfg;

public class FindKthRotation {
    public static void main(String[] args) {
        int[] arr = {5, 1, 2, 3, 4};
        System.out.println("Rotation Count: " + findKRotation(arr));
    }
    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int findKRotation(int[] arr) {
        // Code here
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] >= arr[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left % n;
    }
    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int findKRotationNaive(int[] arr) {
        int n = arr.length;
        int rotationCount = 0;
        int min = arr[rotationCount];
        for (int i = 1; i < n; i++) {
            if (arr[i]<min) {
                min = arr[i];
                rotationCount = i;
            }
        }
        return rotationCount;
    }
}
