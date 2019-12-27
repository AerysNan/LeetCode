/*
 * @lc app=leetcode.cn id=226 lang=java
 *
 * [226] 翻转二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode invertTree(TreeNode root) {
    if (root == null)
      return null;
    TreeNode l = invertTree(root.right);
    TreeNode r = invertTree(root.left);
    root.left = l;
    root.right = r;
    return root;
  }
}
// @lc code=end

