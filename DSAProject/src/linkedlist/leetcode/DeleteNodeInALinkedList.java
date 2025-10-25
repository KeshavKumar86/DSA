package linkedlist.leetcode;

public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        node1.next = new ListNode(5);
        node1.next.next = new ListNode(1);
        node1.next.next.next = new ListNode(9);
        printList(node1);
        deleteNode(node1.next.next);
        printList(node1);
    }
    /*
 Optimal Solution:
 Time Complexity: O(1)
 Space Complexity:O(1)
 */
    public static void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

