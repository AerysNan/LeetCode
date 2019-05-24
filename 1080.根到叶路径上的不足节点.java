/*
 * @lc app=leetcode.cn id=1080 lang=java
 *
 * [1080] 根到叶路径上的不足节点
 */
class Solution {
  public TreeNode sufficientSubset(TreeNode root, int limit) {
    if (!sufficient(root, 0, limit))
      return null;
    return root;
  }

  boolean sufficient(TreeNode node, int current, int limit) {
    int value = current + node.val;
    if (node.left == null && node.right == null)
      return value >= limit;
    boolean sufficientL = node.left == null ? false : sufficient(node.left, value, limit);
    boolean sufficientR = node.right == null ? false : sufficient(node.right, value, limit);
    if (!sufficientL)
      node.left = null;
    if (!sufficientR)
      node.right = null;
    return sufficientL || sufficientR;
  }
}
