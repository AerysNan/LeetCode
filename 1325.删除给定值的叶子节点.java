/*
 * @lc app=leetcode.cn id=1325 lang=java
 *
 * [1325] 删除给定值的叶子节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode removeLeafNodes(TreeNode node, int target) {
    if (node == null)
      return null;
    node.left = removeLeafNodes(node.left, target);
    node.right = removeLeafNodes(node.right, target);
    return node.left == null && node.right == null && node.val == target ? null : node;
  }
}
// @lc code=end

