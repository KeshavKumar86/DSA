package binarysearch.gfg;

public class CeilInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 11, 11, 11, 12, 19};
        int x = 11;
        System.out.println("Ceil's Index: " + findCeil(arr, x));
    }
    /*
Optimal Solution:
Time Complexity: O(logn)
Space Complexity:O(1)
*/
    private static int findCeil(int[] arr, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left == n) {
            return -1;
        }
        return left;
    }
    /*
Naive Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static  int findCeilNaive(int[] arr, int x){
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(arr[i]>=x){
                return i;
            }
        }
        return -1;
    }
}
