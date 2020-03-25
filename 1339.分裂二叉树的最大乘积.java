/*
 * @lc app=leetcode.cn id=1339 lang=java
 *
 * [1339] 分裂二叉树的最大乘积
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  Integer total = null;
  int div = 0;

  public int maxProduct(TreeNode root) {
    total = sum(root);
    sum(root);
    return (int) ((long) (total - div) * (long) div % (long) (1e9 + 7));
  }

  int sum(TreeNode node) {
    int result = node == null ? 0 : sum(node.left) + node.val + sum(node.right);
    if (total != null && Math.abs(2 * div - total) > Math.abs(2 * result - total))
      div = result;
    return result;
  }
}
// @lc code=end

