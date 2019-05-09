import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */
class LRUCache {
  private class CacheNode {
    int key;
    int value;
    CacheNode next;
    CacheNode prev;

    CacheNode(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  private HashMap<Integer, CacheNode> map;
  private CacheNode head;
  private CacheNode tail;
  private int capacity;
  private int size;

  public LRUCache(int capacity) {
    this.map = new HashMap<>();
    this.head = new CacheNode(-1, -1);
    this.tail = new CacheNode(-1, -1);
    this.head.next = this.tail;
    this.tail.prev = this.head;
    this.capacity = capacity;
    this.size = 0;
  }

  public int get(int key) {
    if (map.containsKey(key)) {
      CacheNode node = map.get(key);
      node.next.prev = node.prev;
      node.prev.next = node.next;
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
      node.prev = head;
      return node.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      CacheNode node = map.get(key);
      node.value = value;
      get(key);
    } else {
      CacheNode node = new CacheNode(key, value);
      node.next = head.next;
      head.next.prev = node;
      head.next = node;
      node.prev = head;
      size++;
      map.put(key, node);
      if (size > capacity) {
        CacheNode removeNode = tail.prev;
        tail.prev = removeNode.prev;
        removeNode.prev.next = tail;
        removeNode.next = null;
        removeNode.prev = null;
        map.remove(removeNode.key);
        size--;
      }
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
