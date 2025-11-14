package queue.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {

    }
}

/*
Better Solution: Maintain queue order at every step
Time Complexity: push O(n), pop O(1), top O(1), empty O(1)
Space Complexity:O(2*n) two queue required
*/
class MyQueue {
    Deque<Integer> s1;
    Deque<Integer> s2;

    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
    }

    public void push(int x) {
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

    }

    public int pop() {
        return s1.pop();
    }

    public int peek() {
        return s1.peek();
    }

    public boolean empty() {
        return s1.isEmpty();
    }

    /*
    Optimal Solution: Lazy Shifting (does not maintain queue order at every step)
    Time Complexity: push O(1), pop O(1) amortized, top O(1), empty O(1)
    Space Complexity:O(2*n) two queue required
    */
    public void pushOptimal(int x) {
        s1.push(x);
    }

    public int popOptimal() {
        shift();
        return s2.pop();
    }

    public int peekOptimal() {
        shift();
        return s2.peek();
    }

    public boolean emptyOptimal() {
        return s1.isEmpty() && s2.isEmpty();
    }

    public void shift() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
