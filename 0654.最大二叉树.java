/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {
    return build(nums, 0, nums.length - 1);
  }

  TreeNode build(int[] nums, int l, int r) {
    if (l > r)
      return null;
    if (l == r)
      return new TreeNode(nums[l]);
    int max = Integer.MIN_VALUE, index = -1;
    for (int i = l; i <= r; i++) {
      if (max < nums[i]) {
        max = nums[i];
        index = i;
      }
    }
    TreeNode node = new TreeNode(nums[index]);
    node.left = build(nums, l, index - 1);
    node.right = build(nums, index + 1, r);
    return node;
  }
}
// @lc code=end

