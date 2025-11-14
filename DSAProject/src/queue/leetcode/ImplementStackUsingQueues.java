package queue.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {

    }
}

/*
Better Solution:
Time Complexity: push O(n), pop O(1), top O(1), empty O(1)
Space Complexity:O(2*n) two queue required
*/
class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.add(x);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.remove();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    /*
Optimal Solution:
Time Complexity: push O(n), pop O(1), top O(1), empty O(1)
Space Complexity:O(n)
*/
    public void pushOptimal(int x) {
        queue1.add(x);
        int size = queue1.size();
        for (int i = 0; i < size - 1; i++) {
            queue1.add(queue1.remove());
        }
    }

    public int popOptimal() {
        return queue1.remove();
    }

    public int topOptimal() {
        return queue1.peek();
    }

    public boolean emptyOptimal() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
