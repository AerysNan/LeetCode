/*
 * @lc app=leetcode.cn id=235 lang=java
 *
 * [235] 二叉搜索树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val))
      return root;
    if (root.val > p.val && root.val > q.val)
      return lowestCommonAncestor(root.left, p, q);
    return lowestCommonAncestor(root.right, p, q);
  }
}
// @lc code=end

