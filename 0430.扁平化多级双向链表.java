/*
 * @lc app=leetcode.cn id=430 lang=java
 *
 * [430] 扁平化多级双向链表
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public Node prev; public Node next; public
 * Node child; };
 */
import java.util.LinkedList;

class Solution {
  public Node flatten(Node head) {
    if (head == null)
      return null;
    LinkedList<Node> stack = new LinkedList<>();
    Node pseudo = new Node(), current = pseudo;
    stack.addLast(head);
    while (!stack.isEmpty()) {
      Node node = stack.pollLast();
      if (node.next != null)
        stack.add(node.next);
      if (node.child != null)
        stack.add(node.child);
      current = append(current, node);
    }
    Node result = pseudo.next;
    result.prev = null;
    return result;
  }

  Node append(Node prev, Node node) {
    node.next = null;
    node.child = null;
    node.prev = prev;
    prev.next = node;
    return node;
  }
}
// @lc code=end

