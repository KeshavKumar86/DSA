package slidingwindow;

public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 2, 2};
        int k = 0;
        System.out.println("Total Sub-arrays: " + numberOfSubarraysOptimal(arr, k));

    }
    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int numberOfSubarrays(int[] nums, int k) {
        return sumLessEqualToGoal(nums, k) - sumLessEqualToGoal(nums, k - 1);
    }

    private static int sumLessEqualToGoal(int[] nums, int k) {
        int count = 0;
        int start = 0, end;
        int oddCount = 0;
        if (k < 0) {
            return 0;
        }
        for (end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
            }
            count += (end - start + 1);
        }
        return count;
    }

    private static int numberOfSubarraysOptimal(int[] nums, int k) {
        int oddCount = 0;
        int start = 0, mid = 0, end;
        int totalSubarray = 0;
        for (end = 0; end < nums.length; end++) {
            if (nums[end] % 2 != 0) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[start] % 2 != 0) {
                    oddCount--;
                }
                start++;
                mid = start;
            }
            if (oddCount == k) {
                while (mid < nums.length && nums[mid] % 2 == 0) {
                    mid++;
                }
                totalSubarray += (mid - start + 1);
            }

        }
        return totalSubarray;
    }
}
