package linkedlist.gfg;

public class LinkedListInsertionAtBeginning {
    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(10);
        //original list
        Node temp = node1;
        System.out.println("Original List");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        int x = 1;
        temp = insertAtFront(node1, x);
        System.out.println("\n" + "List After Insertion at beginning");
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
    }
    /*
 Optimal Solution:
 Time Complexity: O(1)
 Space Complexity:O(1)
 */
    private static Node insertAtFront(Node head, int x) {
        Node node = new Node(x);
        node.next = head;
        head = node;
        return head;
    }
}

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
