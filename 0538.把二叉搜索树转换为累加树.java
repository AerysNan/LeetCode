/*
 * @lc app=leetcode.cn id=538 lang=java
 *
 * [538] 把二叉搜索树转换为累加树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int sum = 0;

  public TreeNode convertBST(TreeNode root) {
    traverse(root);
    return root;
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    traverse(node.right);
    sum += node.val;
    node.val = sum;
    traverse(node.left);
  }
}
// @lc code=end

