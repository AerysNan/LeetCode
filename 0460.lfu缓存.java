/*
 * @lc app=leetcode.cn id=460 lang=java
 *
 * [460] LFU缓存
 */

// @lc code=start
import java.util.HashMap;

class Node {
  int key, value, frequency;
  Node prev, next;
  DLL dll;

  public Node(int key, int value) {
    this.key = key;
    this.value = value;
    this.frequency = 1;
  }
}


class DLL {
  int frequency;
  DLL prev, next;
  Node head, tail;

  public DLL(int frequency) {
    head = new Node(-1, -1);
    tail = new Node(-1, -1);
    head.next = tail;
    tail.prev = head;
    this.frequency = frequency;
  }

  void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  void insert(Node node) {
    node.next = head.next;
    head.next.prev = node;
    head.next = node;
    node.prev = head;
    node.dll = this;
  }
}


class LFUCache {
  HashMap<Integer, Node> cache;
  DLL pseudoHead, pseudoTail;
  int size, capacity;

  public LFUCache(int capacity) {
    cache = new HashMap<>(capacity);
    pseudoHead = new DLL(0);
    pseudoTail = new DLL(0);
    pseudoHead.next = pseudoTail;
    pseudoTail.prev = pseudoHead;
    this.capacity = capacity;
  }

  public int get(int key) {
    Node node = cache.get(key);
    if (node == null)
      return -1;
    addFrequency(node);
    return node.value;
  }

  public void put(int key, int value) {
    if (capacity == 0)
      return;
    Node node = cache.get(key);
    if (node != null) {
      node.value = value;
      addFrequency(node);
    } else {
      if (size == capacity) {
        cache.remove(pseudoTail.prev.tail.prev.key);
        pseudoTail.remove(pseudoTail.prev.tail.prev);
        size--;
        if (pseudoTail.prev.head.next == pseudoTail.prev.tail)
          removeDLL(pseudoTail.prev);
      }
      Node newNode = new Node(key, value);
      cache.put(key, newNode);
      if (pseudoTail.prev.frequency != 1) {
        DLL newDLL = new DLL(1);
        insertDLL(newDLL, pseudoTail.prev);
        newDLL.insert(newNode);
      } else
        pseudoTail.prev.insert(newNode);
      size++;
    }
  }

  void addFrequency(Node node) {
    DLL list = node.dll, prev = list.prev;
    list.remove(node);
    if (list.head.next == list.tail)
      removeDLL(list);
    node.frequency++;
    if (prev.frequency != node.frequency) {
      DLL newDLL = new DLL(node.frequency);
      insertDLL(newDLL, prev);
      newDLL.insert(node);
    } else
      prev.insert(node);
  }

  void insertDLL(DLL newDLL, DLL prevDLL) {
    newDLL.next = prevDLL.next;
    newDLL.next.prev = newDLL;
    newDLL.prev = prevDLL;
    prevDLL.next = newDLL;
  }

  void removeDLL(DLL dll) {
    dll.prev.next = dll.next;
    dll.next.prev = dll.prev;
  }
}
/**
 * Your LFUCache object will be instantiated and called as such: LFUCache obj = new
 * LFUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end

