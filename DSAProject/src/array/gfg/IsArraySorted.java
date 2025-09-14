package array.gfg;

public class IsArraySorted {
    public static void main(String[] args) {
        int[] arr = {8, 10, 10, 12, 7};
        System.out.println("Array is Sorted: " + isSortedOptimal(arr));
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static boolean isSorted(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (arr[i] > arr[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static boolean isSortedOptimal(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
