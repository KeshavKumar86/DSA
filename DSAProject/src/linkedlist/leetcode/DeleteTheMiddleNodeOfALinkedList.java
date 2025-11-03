package linkedlist.leetcode;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);
        printList(head);
        ListNode updateHead = deleteMiddle(head);
        printList(updateHead);
    }
    /*
   Optimal Solution:
   Time Complexity: O(n)
   Space Complexity:O(1)
   */
    private static ListNode deleteMiddle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
       /*
   Naive Solution: First count the length of the list and find the middle and delete the middle
   node from the start
   Time Complexity: O(2*n)
   Space Complexity:O(1)
   */
}
