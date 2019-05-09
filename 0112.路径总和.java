/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
 */
class Solution {
  public boolean hasPathSum(TreeNode root, int sum) {
    if (root == null)
      return false;
    return search(root, sum);
  }

  private boolean search(TreeNode node, int val) {
    if (node.left == null && node.right == null)
      return val == node.val;
    boolean valid = false;
    if (node.left != null)
      valid |= search(node.left, val - node.val);
    if (node.right != null)
      valid |= search(node.right, val - node.val);
    return valid;
  }
}
