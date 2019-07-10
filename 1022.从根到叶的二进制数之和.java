/*
 * @lc app=leetcode.cn id=1022 lang=java
 *
 * [1022] 从根到叶的二进制数之和
 */
class Solution {

  int getSum(TreeNode node, int acc) {
    acc = acc * 2 + node.val;
    if (node.left == null && node.right == null)
      return acc;
    int result = 0;
    if (node.left != null)
      result += getSum(node.left, acc);
    if (node.right != null)
      result += getSum(node.right, acc);
    return result;
  }

  public int sumRootToLeaf(TreeNode root) {
    if (root == null)
      return 0;
    return getSum(root, 0);
  }
}
