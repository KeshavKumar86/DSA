package binarysearch.gfg;

public class NumberOfOccurrence {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 2, 3};
        int target = 2;
        System.out.println("Total frequency: " + countFreq(arr, target));
    }
    /*
Optimal Solution:
Time Complexity: O(2*logn)
Space Complexity:O(1)
*/
    private static int countFreq(int[] arr, int target) {
        int firstIndex = binSearch(arr, target, true);
        if (firstIndex == -1) {
            return 0;
        }
        int lastIndex = binSearch(arr, target, false);
        return lastIndex - firstIndex + 1;
    }

    private static int binSearch(int[] nums, int target, boolean firstOccurrence) {
        int left = 0;
        int right = nums.length - 1;
        int resIndex = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                resIndex = mid;
                if (firstOccurrence) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return resIndex;
    }
}
