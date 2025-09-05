package array.leetcode;

public class CheckIfArrayIsSortedAndRotated {
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 2, 4};
        System.out.println("Is Array Sorted: " + isSortedOptimal(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static boolean isSortedOptimal(int[] nums) {
        int n = nums.length;
        int i;
        for (i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }

        for (int j = 1; j < n; j++) {
            if (nums[i % n] > nums[(i + 1) % n]) {
                return false;
            }
            i++;
        }
        return true;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static boolean isSorted(int[] arr) {
        //rotate array at each point and check if we get any array as sorted
        //first check if it is already sorted
        if (isArraySorted(arr)) {
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            rotateArrayBy1(arr);
            if (isArraySorted(arr)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isArraySorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    private static void rotateArrayBy1(int[] arr) {
        int first = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = first;
    }
}
