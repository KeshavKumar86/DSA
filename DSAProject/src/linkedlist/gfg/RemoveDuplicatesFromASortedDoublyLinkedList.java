package linkedlist.gfg;

public class RemoveDuplicatesFromASortedDoublyLinkedList {
    public static void main(String[] args) {

    }

    private static DoublyNode removeDuplicates(DoublyNode head) {
        DoublyNode curr = head;
        while (curr.next != null) {
            if (curr.data == curr.next.data) {
                DoublyNode next = curr.next.next;
                curr.next.prev = null;
                curr.next = next;
                if (next != null) {
                    next.prev = curr;
                }
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
