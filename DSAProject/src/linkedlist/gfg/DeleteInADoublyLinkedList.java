package linkedlist.gfg;

import static linkedlist.gfg.InsertionAtDoublyLinkedList.printList;

public class DeleteInADoublyLinkedList {
    public static void main(String[] args) {
        DoublyNode doublyNode1 = new DoublyNode(1);
        doublyNode1.next = new DoublyNode(2);
        doublyNode1.next.next = new DoublyNode(3);
        doublyNode1.next.next.next = new DoublyNode(4);
        printList(doublyNode1);
        int x = 2;
        DoublyNode newHead = delPos(doublyNode1, x);
        printList(newHead);
    }
    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static DoublyNode delPos(DoublyNode head, int x) {
        if (x == 1) {
            DoublyNode curr = head;
            head = head.next;
            head.prev = null;
            curr.next = null;
            return head;
        }
        DoublyNode curr = head;
        for (int i = 1; i < x - 1; i++) {
            curr = curr.next;
        }
        DoublyNode temp = curr.next;
        if (temp.next != null) {
            temp.next.prev = curr;
        }
        curr.next = temp.next;
        temp.next = null;
        temp.prev = null;
        return head;
    }
}
