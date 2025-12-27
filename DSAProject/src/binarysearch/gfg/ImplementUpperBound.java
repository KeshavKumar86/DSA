package binarysearch.gfg;

public class ImplementUpperBound {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 10, 11, 11, 11, 11, 11, 11, 14, 16, 18, 25};
        int target = 11;
        System.out.println("Element's Index: " + upperBound(arr, target));
    }

    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int upperBound(int[] arr, int target) {
        int n = arr.length;
        int left = 0, right = n - 1;
        int answer = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        return answer;
    }

    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int upperBoundNaive(int[] arr, int target) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] > target) {
                return i;
            }
        }
        return n;
    }
}
