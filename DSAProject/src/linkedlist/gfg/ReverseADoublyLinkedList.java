package linkedlist.gfg;

import static linkedlist.gfg.InsertionAtDoublyLinkedList.printList;

public class ReverseADoublyLinkedList {
    public static void main(String[] args) {
        DoublyNode doublyNode1 = new DoublyNode(1);
        doublyNode1.next = new DoublyNode(2);
        doublyNode1.next.next = new DoublyNode(3);
        doublyNode1.next.next.next = new DoublyNode(4);
        doublyNode1.next.next.next.next = new DoublyNode(5);
        doublyNode1.next.next.next.next.next = new DoublyNode(6);
        printList(doublyNode1);
        DoublyNode updatedHead = reverse(doublyNode1);
        printList(updatedHead);
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static DoublyNode reverse(DoublyNode head) {
        if (head.next == null) {
            return head;
        }
        DoublyNode curr = head;
        DoublyNode prev = curr.prev;
        DoublyNode next = curr.next;
        while (next != null) {
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
            next = next.next;
        }
        curr.next = prev;
        curr.prev = next;
        return curr;
    }
        /*
 Naive Solution: Traverse the list and store the elements in the array and then replace the
 data of the list in the reverse order from array.
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
}
