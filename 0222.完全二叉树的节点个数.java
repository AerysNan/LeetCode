/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int countNodes(TreeNode root) {
    if (root == null)
      return 0;
    int h = height(root), rh = height(root.right);
    if (rh == h - 1)
      return (1 << h) + countNodes(root.right);
    return (1 << h - 1) + countNodes(root.left);
  }

  int height(TreeNode node) {
    int result = -1;
    while (node != null) {
      result++;
      node = node.left;
    }
    return result;
  }
}
// @lc code=end

