/*
 * @lc app=leetcode.cn id=111 lang=java
 *
 * [111] 二叉树的最小深度
 */
class Solution {
  public int minDepth(TreeNode root) {
    if (root == null)
      return 0;
    return search(root);
  }

  private int search(TreeNode node) {
    if (node.left == null && node.right == null)
      return 1;
    int depth = Integer.MAX_VALUE;
    if (node.left != null)
      depth = Math.min(depth, search(node.left) + 1);
    if (node.right != null)
      depth = Math.min(depth, search(node.right) + 1);
    return depth;
  }
}
