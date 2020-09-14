/*
 * @lc app=leetcode.cn id=979 lang=java
 *
 * [979] 在二叉树中分配硬币
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int result;

  public int distributeCoins(TreeNode root) {
    result = 0;
    dfs(root);
    return result;
  }

  public int dfs(TreeNode node) {
    if (node == null)
      return 0;
    int l = dfs(node.left), r = dfs(node.right);
    result += Math.abs(l) + Math.abs(r);
    return node.val + l + r - 1;
  }
}
// @lc code=end
