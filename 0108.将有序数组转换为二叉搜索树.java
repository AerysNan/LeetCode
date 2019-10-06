/*
 * @lc app=leetcode.cn id=108 lang=java
 *
 * [108] 将有序数组转换为二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode sortedArrayToBST(int[] nums) {
    return build(nums, 0, nums.length - 1);
  }

  TreeNode build(int[] nums, int l, int r) {
    if (l > r)
      return null;
    if (l == r)
      return new TreeNode(nums[l]);
    int mid = (l + r) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    root.left = build(nums, l, mid - 1);
    root.right = build(nums, mid + 1, r);
    return root;
  }
}
// @lc code=end

