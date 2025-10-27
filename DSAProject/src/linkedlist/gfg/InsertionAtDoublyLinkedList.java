package linkedlist.gfg;

public class InsertionAtDoublyLinkedList {
    public static void main(String[] args) {
        DoublyNode doublyNode1 = new DoublyNode(1);
        doublyNode1.next = new DoublyNode(2);
        doublyNode1.next.next = new DoublyNode(3);
        doublyNode1.next.next.next = new DoublyNode(4);
        printList(doublyNode1);
        int key = 44;
        int p = 3;
        DoublyNode updatedNode = insertAtPos(doublyNode1, p, key);
        printList(updatedNode);

    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static DoublyNode insertAtPos(DoublyNode head, int p, int x) {
        DoublyNode curr = head;
        for (int i = 0; i < p; i++) {
            curr = curr.next;
        }
        DoublyNode node = new DoublyNode(x);
        node.next = curr.next;
        curr.next = node;
        node.prev = curr;
        return head;
    }
    public static void printList(DoublyNode head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }
        System.out.println();
    }
}

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    DoublyNode(int data) {
        this.data = data;
        next = prev = null;
    }
}
