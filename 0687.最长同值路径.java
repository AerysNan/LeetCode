/*
 * @lc app=leetcode.cn id=687 lang=java
 *
 * [687] 最长同值路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int result = 0;

  public int longestUnivaluePath(TreeNode root) {
    dfs(root);
    return result;
  }

  int dfs(TreeNode node) {
    if (node == null)
      return 0;
    int l = dfs(node.left), r = dfs(node.right);
    int ll = node.left != null && node.left.val == node.val ? l + 1 : 0;
    int rr = node.right != null && node.right.val == node.val ? r + 1 : 0;
    result = Math.max(result, ll + rr);
    return Math.max(ll, rr);
  }
}
// @lc code=end

