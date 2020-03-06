/*
 * @lc app=leetcode.cn id=998 lang=java
 *
 * [998] 最大二叉树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode insertIntoMaxTree(TreeNode root, int val) {
    if (root.val < val) {
      TreeNode node = new TreeNode(val);
      node.left = root;
      return node;
    }
    root.right = root.right == null ? new TreeNode(val) : insertIntoMaxTree(root.right, val);
    return root;
  }
}
// @lc code=end

