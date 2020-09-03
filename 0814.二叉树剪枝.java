/*
 * @lc app=leetcode.cn id=814 lang=java
 *
 * [814] 二叉树剪枝
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
  public TreeNode pruneTree(TreeNode root) {
    return prune(root) ? null : root;
  }

  boolean prune(TreeNode node) {
    if (node == null)
      return true;
    boolean l = prune(node.left), r = prune(node.right);
    if (l)
      node.left = null;
    if (r)
      node.right = null;
    return l && r && node.val == 0;
  }
}
// @lc code=end
