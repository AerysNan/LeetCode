/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public void flatten(TreeNode root) {
    if (root == null)
      return;
    TreeNode l = root.left, r = root.right, node = root;
    flatten(l);
    flatten(r);
    root.left = null;
    root.right = l;
    while (node.right != null)
      node = node.right;
    node.right = r;
  }
}
// @lc code=end

