/*
 * @lc app=leetcode.cn id=623 lang=java
 *
 * [623] 在二叉树中增加一行
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;

class Solution {
  public TreeNode addOneRow(TreeNode root, int v, int d) {
    if (d == 1) {
      TreeNode node = new TreeNode(v);
      node.left = root;
      return node;
    }
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (d > 2) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
        if (node.left != null)
          queue.addFirst(node.left);
        if (node.right != null)
          queue.addFirst(node.right);
      }
      d--;
    }
    while (!queue.isEmpty()) {
      TreeNode node = queue.poll();
      TreeNode l = new TreeNode(v), r = new TreeNode(v);
      l.left = node.left;
      r.right = node.right;
      node.left = l;
      node.right = r;
    }
    return root;
  }
}
// @lc code=end

