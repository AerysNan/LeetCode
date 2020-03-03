/*
 * @lc app=leetcode.cn id=530 lang=java
 *
 * [530] 二叉搜索树的最小绝对差
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int result = Integer.MAX_VALUE;
  Integer prev = null;

  public int getMinimumDifference(TreeNode root) {
    traverse(root);
    return result;
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    traverse(node.left);
    if (prev != null)
      result = Math.min(result, Math.abs(node.val - prev));
    prev = node.val;
    traverse(node.right);
  }
}
// @lc code=end

