package queue.gfg;

public class QueueUsingArray {
    public static void main(String[] args) {

    }
}
/*
Optimal Solution:
Time Complexity Of All Operations: O(1)
Space Complexity:O(n)
*/
class myQueue {

    int[] queue;
    int front;
    int rear;
    int capacity;
    int size;

    // Constructor
    public myQueue(int n) {
        // Define Data Structures
        queue = new int[n];
        front = 0;
        rear = -1;
        capacity = n;
        size = 0;
    }

    public boolean isEmpty() {
        // Check if queue is empty
        return size == 0;
    }

    public boolean isFull() {
        // Check if queue is full
        return size == capacity;
    }

    public void enqueue(int x) {
        // if queue is full
        if (isFull()) {
            System.out.println("Queue Full: Cannot enqueue " + x);
        } else {
            rear = (rear + 1) % capacity;
            queue[rear] = x;
            size++;
        }
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty: Cannot dequeue");
        } else {
            front = (front + 1) % capacity;
            size--;
        }
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }

    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[rear];
    }
}

