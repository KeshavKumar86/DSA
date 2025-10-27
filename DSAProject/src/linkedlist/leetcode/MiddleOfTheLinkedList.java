package linkedlist.leetcode;

import static linkedlist.leetcode.DeleteNodeInALinkedList.printList;

public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        node1.next = new ListNode(2);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(4);
        node1.next.next.next.next = new ListNode(5);
        node1.next.next.next.next.next = new ListNode(6);
        printList(node1);
        ListNode middle = middleNode(node1);
        System.out.println("Middle Node's Value: " + middle.val);
    }

    /*
  Optimal Solution:
  Time Complexity: O(n)
  Space Complexity:O(1)
  */
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
       /*
 Naive Solution: Iterate the list and count the length of the list and then again iterate till
 middle of the list.
 Time Complexity: O(2*n)
 Space Complexity:O(1)
 */
}
