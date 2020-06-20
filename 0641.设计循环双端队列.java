/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class Node {
    public int value;
    public Node prev, next;

    public Node(int value) {
        this.value = value;
    }
}

class MyCircularDeque {
    private int size, capacity;
    private Node head, tail;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.head = new Node(0);
        this.tail = new Node(0);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertFront(int value) {
        if (size == capacity)
            return false;
        Node node = new Node(value);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean insertLast(int value) {
        if (size == capacity)
            return false;
        Node node = new Node(value);
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        node.next = tail;
        size++;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteFront() {
        if (size == 0)
            return false;
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public boolean deleteLast() {
        if (size == 0)
            return false;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
        return true;

    }

    /** Get the front item from the deque. */
    public int getFront() {
        return size == 0 ? -1 : head.next.value;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        return size == 0 ? -1 : tail.prev.value;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k); boolean param_1 =
 * obj.insertFront(value); boolean param_2 = obj.insertLast(value); boolean
 * param_3 = obj.deleteFront(); boolean param_4 = obj.deleteLast(); int param_5
 * = obj.getFront(); int param_6 = obj.getRear(); boolean param_7 =
 * obj.isEmpty(); boolean param_8 = obj.isFull();
 */
// @lc code=end
