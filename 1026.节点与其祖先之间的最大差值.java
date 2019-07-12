/*
 * @lc app=leetcode.cn id=1026 lang=java
 *
 * [1026] 节点与其祖先之间的最大差值
 */
class Solution {
  int result;

  public int maxAncestorDiff(TreeNode root) {
    if (root == null)
      return 0;
    result = -1;
    updateDiff(root, root.val, root.val);
    return result;
  }

  void updateDiff(TreeNode node, int max, int min) {
    result = Math.max(result, Math.abs(max - node.val));
    result = Math.max(result, Math.abs(min - node.val));
    max = Math.max(node.val, max);
    min = Math.min(node.val, min);
    if (node.left != null)
      updateDiff(node.left, max, min);
    if (node.right != null)
      updateDiff(node.right, max, min);
  }
}
