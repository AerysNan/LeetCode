/*
 * @lc app=leetcode.cn id=110 lang=java
 *
 * [110] 平衡二叉树
 */
class Solution {
  public boolean isBalanced(TreeNode root) {
    if (root == null)
      return true;
    return check(root) > 0;
  }

  private int check(TreeNode node) {
    if (node == null)
      return 0;
    int lHeight = check(node.left);
    int rHeight = check(node.right);
    if (lHeight < 0 || rHeight < 0 || Math.abs(lHeight - rHeight) > 1)
      return -1;
    return Math.max(lHeight, rHeight) + 1;
  }
}
