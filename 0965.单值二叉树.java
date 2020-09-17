/*
 * @lc app=leetcode.cn id=965 lang=java
 *
 * [965] 单值二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isUnivalTree(TreeNode root) {
    if (root == null)
      return true;
    return (root.left == null ? true : (root.val == root.left.val && isUnivalTree(root.left)))
        && (root.right == null ? true : (root.val == root.right.val && isUnivalTree(root.right)));
  }
}
// @lc code=end
