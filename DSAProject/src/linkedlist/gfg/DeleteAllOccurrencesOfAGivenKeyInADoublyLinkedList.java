package linkedlist.gfg;

public class DeleteAllOccurrencesOfAGivenKeyInADoublyLinkedList {
    public static void main(String[] args) {

    }

    /*
 Optimal Solution:
 Time Complexity: O(n)
 Space Complexity:O(1)
 */
    private static DoublyNode deleteAllOccurOfX(DoublyNode head, int x) {
        DoublyNode dummy = new DoublyNode(-1);
        DoublyNode curr = dummy;
        while (head != null) {
            if (head.data != x) {
                curr.next = head;
                head.prev = curr;
                curr = curr.next;
            }
            head = head.next;
        }
        curr.next = null;
        DoublyNode newHead = dummy.next;
        if (newHead != null) {
            newHead.prev = null;
        }
        return newHead;
    }

        /*
 Naive Solution: Iterate the list and add the data in a array list and then iterate the array list
 and put the non x data back in the linked list from starting and break the last link.
 Time Complexity: O(n)
 Space Complexity:O(n)
 */
}
