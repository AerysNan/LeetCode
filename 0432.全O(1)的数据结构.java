import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=432 lang=java
 *
 * [432] 全 O(1) 的数据结构
 *
 * https://leetcode-cn.com/problems/all-oone-data-structure/description/
 *
 * algorithms
 * Hard (37.15%)
 * Total Accepted:    581
 * Total Submissions: 1.6K
 * Testcase Example:  '["AllOne","getMaxKey","getMinKey"]\n[[],[],[]]'
 *
 * 实现一个数据结构支持以下操作：
 *
 *
 * Inc(key) - 插入一个新的值为 1 的 key。或者使一个存在的 key 增加一，保证 key 不为空字符串。
 * Dec(key) - 如果这个 key 的值是 1，那么把他从数据结构中移除掉。否者使一个存在的 key 值减一。如果这个 key
 * 不存在，这个函数不做任何事情。key 保证不为空字符串。
 * GetMaxKey() - 返回 key 中值最大的任意一个。如果没有元素存在，返回一个空字符串""。
 * GetMinKey() - 返回 key 中值最小的任意一个。如果没有元素存在，返回一个空字符串""。
 *
 *
 * 挑战：以 O(1) 的时间复杂度实现所有操作。
 *
 */
public class AllOne {
  private class Bucket {
    int value;
    HashSet<String> set;
    Bucket prev;
    Bucket next;

    Bucket(int value) {
      this.value = value;
      this.set = new HashSet<>();
    }
  }

  private HashMap<String, Integer> stringMap;
  private HashMap<Integer, Bucket> bucketMap;
  private Bucket head;
  private Bucket tail;

  /** Initialize your data structure here. */
  public AllOne() {
    this.stringMap = new HashMap<>();
    this.bucketMap = new HashMap<>();
    this.head = new Bucket(0);
    this.tail = new Bucket(Integer.MAX_VALUE);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    bucketMap.put(0, this.head);
  }

  private Bucket GetOrInsertAfter(Bucket bucket, int value) {
    if (bucketMap.containsKey(value))
      return bucketMap.get(value);
    Bucket newBucket = new Bucket(value);
    newBucket.next = bucket.next;
    newBucket.prev = bucket;
    newBucket.next.prev = newBucket;
    newBucket.prev.next = newBucket;
    bucketMap.put(value, newBucket);
    return newBucket;
  }

  private Bucket GetOrInsertBefore(Bucket bucket, int value) {
    if (bucketMap.containsKey(value))
      return bucketMap.get(value);
    Bucket newBucket = new Bucket(value);
    newBucket.next = bucket;
    newBucket.prev = bucket.prev;
    newBucket.prev.next = newBucket;
    newBucket.next.prev = newBucket;
    bucketMap.put(value, newBucket);
    return newBucket;
  }

  private void RemoveIfEmpty(Bucket bucket) {
    if (!bucket.set.isEmpty())
      return;
    bucket.next.prev = bucket.prev;
    bucket.prev.next = bucket.next;
    bucket.prev = null;
    bucket.next = null;
    bucketMap.remove(bucket.value);
  }

  /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
  public void inc(String key) {
    int value = stringMap.containsKey(key) ? stringMap.get(key) : 0;
    Bucket bucket = bucketMap.get(value);
    Bucket newBucket = GetOrInsertAfter(bucket, value + 1);
    newBucket.set.add(key);
    if (bucket != this.head) {
      bucket.set.remove(key);
      RemoveIfEmpty(bucket);
    }
    stringMap.put(key, value + 1);
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data
   * structure.
   */
  public void dec(String key) {
    if (!stringMap.containsKey(key))
      return;
    int value = stringMap.get(key);
    Bucket bucket = bucketMap.get(value);
    if (value == 1)
      stringMap.remove(key);
    else {
      stringMap.put(key, value - 1);
      Bucket newBucket = GetOrInsertBefore(bucket, value - 1);
      newBucket.set.add(key);
    }
    bucket.set.remove(key);
    RemoveIfEmpty(bucket);

  }

  /** Returns one of the keys with maximal value. */
  public String getMaxKey() {
    return tail.prev == head ? "" : tail.prev.set.iterator().next();
  }

  /** Returns one of the keys with Minimal value. */
  public String getMinKey() {
    return head.next == tail ? "" : head.next.set.iterator().next();
  }
}

/**
 * Your AllOne object will be instantiated and called as such: AllOne obj = new
 * AllOne(); obj.inc(key); obj.dec(key); String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
