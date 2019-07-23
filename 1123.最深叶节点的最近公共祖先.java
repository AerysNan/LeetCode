/*
 * @lc app=leetcode.cn id=1123 lang=java
 *
 * [1123] 最深叶节点的最近公共祖先
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode lcaDeepestLeaves(TreeNode root) {
    int L = getDepth(root.left), R = getDepth(root.right);
    if (L > R)
      return lcaDeepestLeaves(root.left);
    if (L < R)
      return lcaDeepestLeaves(root.right);
    return root;
  }

  int getDepth(TreeNode node) {
    if (node == null)
      return 0;
    return 1 + Math.max(getDepth(node.left), getDepth(node.right));
  }
}
