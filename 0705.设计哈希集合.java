/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
import java.util.LinkedList;

class Bucket {
    private LinkedList<Integer> container;

    public Bucket() {
        container = new LinkedList<Integer>();
    }

    public void insert(int key) {
        if (!exists(key))
            container.addFirst(key);
    }

    public void delete(int key) {
        container.remove(new Integer(key));
    }

    public boolean exists(int key) {
        return container.indexOf(key) >= 0;
    }
}

class MyHashSet {
    private Bucket[] bucketArray;
    private int keyRange;

    /** Initialize your data structure here. */
    public MyHashSet() {
        keyRange = 769;
        bucketArray = new Bucket[keyRange];
        for (int i = 0; i < keyRange; ++i)
            bucketArray[i] = new Bucket();
    }

    public void add(int key) {
        bucketArray[key % keyRange].insert(key);
    }

    public void remove(int key) {
        bucketArray[key % keyRange].delete(key);
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return bucketArray[key % keyRange].exists(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such: MyHashSet obj
 * = new MyHashSet(); obj.add(key); obj.remove(key); boolean param_3 =
 * obj.contains(key);
 */
// @lc code=end
