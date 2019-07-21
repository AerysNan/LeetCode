/*
 * @lc app=leetcode.cn id=1008 lang=java
 *
 * [1008] 先序遍历构造二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode bstFromPreorder(int[] preorder) {
    return build(preorder, 0, preorder.length);
  }

  TreeNode build(int[] preorder, int l, int h) {
    if (l >= h)
      return null;
    int value = preorder[l];
    TreeNode node = new TreeNode(value);
    int index = l + 1;
    while (index < preorder.length && preorder[index] < value)
      index++;
    node.left = build(preorder, l + 1, index);
    node.right = build(preorder, index, h);
    return node;
  }
}
