/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int pathSum(TreeNode root, int sum) {
    if (root == null)
      return 0;
    return search(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
  }

  int search(TreeNode node, int sum) {
    if (node == null)
      return 0;
    int result = node.val == sum ? 1 : 0;
    result += search(node.left, sum - node.val) + search(node.right, sum - node.val);
    return result;
  }
}
// @lc code=end

