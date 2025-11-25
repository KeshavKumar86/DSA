package stack.leetcode;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Total Water Trapped: " + trapOptimal(arr));

    }

    /*
  Optimal Solution: Because min height is limiting the water trapped at an index, so we can use 2
  pointers and have max of left side and right side, and we can move the min one.
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static int trapOptimal(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;
        int res = 0;
        int leftMax = 0, rightMax = 0;
        while (left <= right) {
            leftMax = Math.max(leftMax, arr[left]);
            rightMax = Math.max(rightMax, arr[right]);
            if (leftMax < rightMax) {
                res += leftMax - arr[left];
                left++;
            } else {
                res += rightMax - arr[right];
                right--;
            }
        }
        return res;
    }
    /*
  Better Solution:
  Time Complexity: O(3*n)
  Space Complexity:O(2*n)
  */
    private static int trapBetter(int[] arr) {
        int n = arr.length;
        int[] leftMax = new int[n];
        int max = arr[0];
        leftMax[0] = max;
        int[] rightMax = new int[n];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
            leftMax[i] = max;
        }
        max = arr[n - 1];
        rightMax[n - 1] = max;
        for (int i = n - 2; i >= 0; i--) {
            max = Math.max(max, arr[i]);
            rightMax[i] = max;
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            int waterTrapped = min - arr[i];
            if (waterTrapped > 0) {
                res += waterTrapped;
            }
        }
        return res;
    }
}
