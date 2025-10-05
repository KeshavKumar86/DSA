package binarysearch.leetcode;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 1};
        int days = 4;
        System.out.println("Minimum Weight Capacity: " + shipWithinDays(arr, days));
    }

    /*
Optimal Solution:
Time Complexity: O(n * log(sum(weights) - max(weights)))
Space Complexity:O(1)
*/
    private static int shipWithinDays(int[] weights, int days) {
        int[] range = sum(weights);
        int left = range[0];
        int right = range[1];
        int res = right;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (getDays(weights, mid) <= days) {
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
Time Complexity: O(n * sum(weights) - max(weights))
Space Complexity:O(1)
*/
    private static int shipWithinDaysNaive(int[] weights, int days) {
        int[] range = sum(weights);
        int min = range[0];
        int max = range[1];
        for (int i = min; i <= max; i++) {
            if (getDays(weights, i) <= days) {
                return i;
            }
        }
        return -1;
    }

    private static int getDays(int[] weights, int capacity) {
        int currSum = 0;
        int days = 1;
        for (int weight : weights) {
            if (currSum + weight > capacity) {
                days++;
                currSum = 0;
            }
            currSum += weight;
        }
        return days;
    }

    private static int[] sum(int[] arr) {
        int sum = 0;
        int max = 0;
        for (int element : arr) {
            sum += element;
            max = Math.max(max, element);
        }
        return new int[]{max, sum};
    }
}
