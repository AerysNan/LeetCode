/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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
import java.util.LinkedList;

class Solution {
  public Node connect(Node root) {
    if (root == null)
      return null;
    execute(root.left, root.right);
    return root;
  }

  void execute(Node l, Node r) {
    if (l != null) {
      l.next = r;
      execute(l.left, l.right);
      if (r != null)
        execute(l.right, r.left);
    }
    if (r != null)
      execute(r.left, r.right);
  }
}
// @lc code=end

