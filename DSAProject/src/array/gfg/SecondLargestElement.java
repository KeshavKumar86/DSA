package array.gfg;

public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {20, 10, 20, 8, 12};
        int index = secondLargest(arr);
        System.out.println("Second Largest Element's Index: " + index);
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static int secondLargestOptimal(int[] arr) {
        int largestIndex = 0;
        int secLargestIndex = -1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[largestIndex]) {
                secLargestIndex = largestIndex;
                largestIndex = i;
            } else if (arr[i] < arr[largestIndex]) {
                if (secLargestIndex == -1 || arr[secLargestIndex] < arr[i]) {
                    secLargestIndex = i;
                }
            }
        }
        return secLargestIndex;
    }
    /*
Naive Solution:
Time Complexity: O(n) (but takes 2 iterations)
Space Complexity:O(1)
*/
    private static int secondLargest(int[] arr) {

        int largestIndex = largest(arr);
        int secondLargest = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[largestIndex]) {
                if (secondLargest == -1 || arr[i] > arr[secondLargest]) {
                    secondLargest = i;
                }
            }
        }
        return secondLargest;
    }

    private static int largest(int[] arr) {
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[index]) {
                index = i;
            }
        }
        return index;
    }
}
