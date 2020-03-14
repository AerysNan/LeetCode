/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int result = 0;

  public int longestZigZag(TreeNode root) {
    if (root == null)
      return 0;
    dfs(root.left, true, 1);
    dfs(root.right, false, 1);
    return result;
  }

  void dfs(TreeNode node, boolean left, int length) {
    if (node == null)
      return;
    result = Math.max(result, length);
    if (left) {
      dfs(node.right, false, length + 1);
      dfs(node.left, true, 1);
    } else {
      dfs(node.left, true, length + 1);
      dfs(node.right, false, 1);
    }
  }
}
// @lc code=end

