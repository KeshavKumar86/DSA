package linkedlist.leetcode;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 1;
        printList(head);
        ListNode updateHead = removeNthFromEnd(head, n);
        printList(updateHead);
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    private static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode prev = head, curr = head;
        for (int i = 0; i < n; i++) {
            curr = curr.next;
        }
        // if n = size of the list then curr will past the last node
        if (curr == null) {
            return prev.next;
        }
        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    /*
Optimal Solution:
Time Complexity: O(n)
Space Complexity:O(1)
*/
    private static ListNode removeNthFromEndStandard(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy, curr = dummy;
        for (int i = 0; i <= n; i++) {
            curr = curr.next;
        }
        while (curr != null) {
            prev = prev.next;
            curr = curr.next;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
        /*
Naive Solution: Just Reverse the list and delete the nth node from the start and then reverse again
Time Complexity: O(3*n)
Space Complexity:O(1)
*/
}
