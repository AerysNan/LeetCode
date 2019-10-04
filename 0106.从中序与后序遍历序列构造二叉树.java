/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    return build(postorder, 0, postorder.length - 1, inorder, 0, postorder.length - 1);
  }

  TreeNode build(int[] postorder, int postl, int postr, int[] inorder, int inl, int inr) {
    if (postl > postr)
      return null;
    int rootValue = postorder[postr];
    if (postl == postr)
      return new TreeNode(rootValue);
    int pivot = inl;
    for (; pivot <= inr; pivot++)
      if (inorder[pivot] == rootValue)
        break;
    TreeNode root = new TreeNode(rootValue);
    root.left = build(postorder, postl, postl + pivot - inl - 1, inorder, inl, pivot - 1);
    root.right = build(postorder, postl + pivot - inl, postr - 1, inorder, pivot + 1, inr);
    return root;
  }

}
// @lc code=end

