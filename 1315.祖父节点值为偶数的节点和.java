/*
 * @lc app=leetcode.cn id=1315 lang=java
 *
 * [1315] 祖父节点值为偶数的节点和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int sumEvenGrandparent(TreeNode node) {
    if (node == null)
      return 0;
    int result = sumEvenGrandparent(node.left) + sumEvenGrandparent(node.right);
    if (node.val % 2 != 0)
      return result;
    if (node.left != null) {
      result += node.left.left == null ? 0 : node.left.left.val;
      result += node.left.right == null ? 0 : node.left.right.val;
    }
    if (node.right != null) {
      result += node.right.left == null ? 0 : node.right.left.val;
      result += node.right.right == null ? 0 : node.right.right.val;
    }
    return result;
  }
}
// @lc code=end

