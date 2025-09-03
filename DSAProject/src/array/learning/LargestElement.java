package array.learning;

public class LargestElement {
    public static void main(String[] args) {
        int[] arr = {40, 8, 5, 100};
        int largestIndex = largest(arr);
        System.out.println("Largest Element: " + arr[largestIndex]);
    }

    /*
Efficient Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
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

