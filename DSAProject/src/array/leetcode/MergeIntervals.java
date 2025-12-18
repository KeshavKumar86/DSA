package array.leetcode;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = new int[4][];
        arr[0] = new int[]{1, 4};
        arr[1] = new int[]{5, 12};
        arr[2] = new int[]{12, 17};
        arr[3] = new int[]{15, 18};
        int[][] result = merge(arr);
        for (int[] element : result) {
            System.out.print(Arrays.toString(element) + " ");
        }
    }
    /*
Optimal Solution:
Time Complexity: O(nlogn)
Space Complexity:O(n)
*/
    private static int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] result = new int[n][2];
        int index = 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        result[index++] = intervals[0];
        for (int i = 1; i < n; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            //if overlapping intervals then merge them else just add current interval
            if (result[index - 1][1] >= start) {
                result[index - 1][1] = Math.max(result[index - 1][1], end);
            } else {
                result[index++] = intervals[i];
            }
        }
        int[][] finalResult = new int[index][];
        System.arraycopy(result, 0, finalResult, 0, index);
        return finalResult;
    }
        /*
Naive Solution: We can start with first element and nested-ly check what are all the intervals we can
merge (It is hard to code, this understanding is enough)
Time Complexity: O(n^2)
Space Complexity:O(n)
*/
}
