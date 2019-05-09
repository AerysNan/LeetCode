/*
 * @lc app=leetcode.cn id=124 lang=java
 *
 * [124] 二叉树中的最大路径和
 */
class Solution {
  private int pathLength = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    search(root);
    return pathLength;
  }

  private int search(TreeNode node) {
    if (node == null)
      return 0;
    int lVal = Math.max(0, search(node.left));
    int rVal = Math.max(0, search(node.right));
    pathLength = Math.max(pathLength, node.val + lVal + rVal);
    return Math.max(lVal, rVal) + node.val;
  }
}
