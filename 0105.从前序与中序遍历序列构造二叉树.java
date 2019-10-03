/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
  }

  TreeNode build(int[] preorder, int prel, int prer, int[] inorder, int inl, int inr) {
    if (prel > prer)
      return null;
    int rootValue = preorder[prel];
    if (prel == prer)
      return new TreeNode(rootValue);
    int pivot = inl;
    for (; pivot <= inr; pivot++)
      if (inorder[pivot] == rootValue)
        break;
    TreeNode root = new TreeNode(rootValue);
    root.left = build(preorder, prel + 1, prel + pivot - inl, inorder, inl, pivot - 1);
    root.right = build(preorder, prel + pivot - inl + 1, prer, inorder, pivot + 1, inr);
    return root;
  }
}
// @lc code=end

