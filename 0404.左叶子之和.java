/*
 * @lc app=leetcode.cn id=404 lang=java
 *
 * [404] 左叶子之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int sumOfLeftLeaves(TreeNode root) {
    if (root == null)
      return 0;
    return (isLeaf(root.left) ? root.left.val : 0) + sumOfLeftLeaves(root.left)
        + sumOfLeftLeaves(root.right);
  }

  boolean isLeaf(TreeNode node) {
    return node != null && node.left == null && node.right == null;
  }
}
// @lc code=end

