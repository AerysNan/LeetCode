/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
import java.util.LinkedList;
import java.util.ArrayList;

class Pair {
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Bucket {
    private LinkedList<Pair> bucket;

    public Bucket() {
        bucket = new LinkedList<Pair>();
    }

    public int get(int key) {
        for (Pair pair : bucket)
            if (pair.first == key)
                return pair.second;
        return -1;
    }

    public void update(int key, int value) {
        boolean found = false;
        for (Pair pair : bucket) {
            if (pair.first == key) {
                pair.second = value;
                found = true;
            }
        }
        if (!found)
            bucket.add(new Pair(key, value));
    }

    public void remove(int key) {
        for (Pair pair : bucket) {
            if (pair.first == key) {
                bucket.remove(pair);
                break;
            }
        }
    }
}

class MyHashMap {
    private int count;
    private ArrayList<Bucket> map;

    /** Initialize your data structure here. */
    public MyHashMap() {
        count = 2069;
        map = new ArrayList<Bucket>();
        for (int i = 0; i < count; i++)
            map.add(new Bucket());
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        map.get(key % count).update(key, value);
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map
     * contains no mapping for the key
     */
    public int get(int key) {
        return map.get(key % count).get(key);
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping
     * for the key
     */
    public void remove(int key) {
        map.get(key % count).remove(key);
    }
}
/**
 * Your MyHashMap object will be instantiated and called as such: MyHashMap obj
 * = new MyHashMap(); obj.put(key,value); int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end
