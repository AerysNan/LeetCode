/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
 * // Definition for a Node. class Node { public int val; public Node left; public Node right;
 * public Node next;
 *
 * public Node() {}
 *
 * public Node(int _val) { val = _val; }
 *
 * public Node(int _val, Node _left, Node _right, Node _next) { val = _val; left = _left; right =
 * _right; next = _next; } };
 */
class Solution {
  public Node connect(Node root) {
    Node pseudo = new Node(-1), prev = pseudo, node = root;
    while (node != null) {
      if (node.left != null) {
        prev.next = node.left;
        prev = prev.next;
      }
      if (node.right != null) {
        prev.next = node.right;
        prev = prev.next;
      }
      node = node.next;
      if (node == null) {
        prev = pseudo;
        node = pseudo.next;
        pseudo.next = null;
      }
    }
    return root;
  }
}

// @lc code=end

