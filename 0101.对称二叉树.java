/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isSymmetric(TreeNode root) {
    if (root == null)
      return true;
    return check(root.left, root.right);
  }

  boolean check(TreeNode node1, TreeNode node2) {
    if (node1 == null && node2 == null)
      return true;
    if (node1 == null && node2 != null || node1 != null && node2 == null || node1.val != node2.val)
      return false;
    return check(node1.left, node2.right) && check(node1.right, node2.left);
  }
}
// @lc code=end
