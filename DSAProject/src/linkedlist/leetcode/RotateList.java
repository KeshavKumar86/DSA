package linkedlist.leetcode;

public class RotateList {
    public static void main(String[] args) {

    }
    /*
 Optimal Solution:
 Time Complexity: O(2*n)
 Space Complexity:O(1)
 */
    private static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        //find the length of the list
        int length = 1;
        ListNode curr = head;
        while (curr.next != null) {
            length++;
            curr = curr.next;
        }
        curr.next = head;
        //calculate effective rotation
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = head;
        while (stepsToNewHead > 1) {
            stepsToNewHead--;
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
        /*
 Naive Solution: 1. Store the elements in the arrayList and that rotate the arraylist and then update
 the nodes of the list.
  Time Complexity: O(2*n)
 Space Complexity:O(n)
 2. Rotate by 1 and then loop it K times.
 Time Complexity: O(n*k)
 Space Complexity:O(1)
 */
}
