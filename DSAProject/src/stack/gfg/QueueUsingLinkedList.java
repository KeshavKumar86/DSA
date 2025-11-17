package stack.gfg;

public class QueueUsingLinkedList {
    public static void main(String[] args) {

    }
}

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

// Queue class
class myQueue {
    Node front;
    Node rear;
    int size;

    public myQueue() {
        // Initialize your data members
        front = null;
        rear = null;
        size = 0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        return size == 0;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        Node node = new Node(x);
        if (size == 0) {
            front = node;
            rear = node;
        } else {
            rear.next = node;
            rear = node;
        }
        size++;
    }

    public void dequeue() {
        // Removes the front element of the queue
        if (size == 1) {
            rear = null;
        }

        front = front.next;
        size--;

    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if (size == 0) {
            return -1;
        }
        return front.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return size;
    }
}

