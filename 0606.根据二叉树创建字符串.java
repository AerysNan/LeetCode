/*
 * @lc app=leetcode.cn id=606 lang=java
 *
 * [606] 根据二叉树创建字符串
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  StringBuilder result = new StringBuilder();

  public String tree2str(TreeNode t) {
    traverse(t);
    return result.toString();
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    result.append(node.val);
    if (node.left != null || node.right != null) {
      result.append('(');
      traverse(node.left);
      result.append(')');
    }
    if (node.right != null) {
      result.append('(');
      traverse(node.right);
      result.append(')');
    }
  }
}
// @lc code=end

