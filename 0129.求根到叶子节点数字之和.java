/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根到叶子节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int sumNumbers(TreeNode root) {
    if (root == null)
      return 0;
    return traverse(root, root.val);
  }

  int traverse(TreeNode node, int current) {
    if (node.left == null && node.right == null)
      return current;
    int result = 0;
    if (node.left != null)
      result += traverse(node.left, current * 10 + node.left.val);
    if (node.right != null)
      result += traverse(node.right, current * 10 + node.right.val);
    return result;
  }
}
// @lc code=end

