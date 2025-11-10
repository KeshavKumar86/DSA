package linkedlist.gfg;

import java.util.ArrayList;

public class FindPairsWithGivenSumInDoublyLinkedList {
    public static void main(String[] args) {

    }
    /*
 Optimal Solution:
 Time Complexity: O(2*n)
 Space Complexity:O(1)
 */
    private static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target,
                                                                      DoublyNode head) {
        DoublyNode end = head;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (end.next != null) {
            end = end.next;
        }
        DoublyNode start = head;
        while (start != end) {
            if (start.data + end.data == target) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(start.data);
                pair.add(end.data);
                result.add(pair);
                end = end.prev;
            } else if (start.data + end.data > target) {
                end = end.prev;
            } else {
                start = start.next;
            }
        }
        return result;
    }
        /*
 Naive Solution: Store the elements in the arrayList and just apply 2 pointer technique.
 Time Complexity: O(2*n)
 Space Complexity:O(n)
 */
}
