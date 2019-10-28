/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 复制带随机指针的链表
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { int val; Node next; Node random;
 *
 * public Node(int val) { this.val = val; this.next = null; this.random = null; } }
 */
import java.util.HashMap;

class Solution {
  public Node copyRandomList(Node head) {
    HashMap<Integer, Node> map = new HashMap<>();
    HashMap<Node, Integer> id = new HashMap<>();
    Node fake = new Node(-1), current = head, clone = fake;
    int num = 0;
    while (current != null) {
      id.put(current, num);
      Node next = new Node(current.val);
      map.put(num++, next);
      clone.next = next;
      clone = clone.next;
      current = current.next;
    }
    current = head;
    clone = fake.next;
    while (current != null) {
      if (current.random != null)
        map.get(id.get(current)).random = map.get(id.get(current.random));
      current = current.next;
    }
    return fake.next;
  }
}
// @lc code=end

