package array.leetcode;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println("Missing Number: " + missingNumber(arr));
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int missingNumberOptimal(int[] arr) {
        int n = arr.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int element : arr) {
            actualSum += element;
        }
        return expectedSum - actualSum;
    }

    /*
Naive Solution:
Time Complexity: O(n^2)
Space Complexity:O(1)
*/
    private static int missingNumber(int[] arr) {
        for (int num = 0; num <= arr.length; num++) {
            boolean flag = false;
            for (int element : arr) {
                if (element == num) {
                    flag = true;
                    break;
                }
            }
            if(!flag){
                return num;
            }
        }
        return -1;
    }

}
