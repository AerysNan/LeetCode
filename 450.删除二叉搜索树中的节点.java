/*
 * @lc app=leetcode.cn id=450 lang=java
 *
 * [450] 删除二叉搜索树中的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public TreeNode deleteNode(TreeNode root, int key) {
    if (root == null)
      return null;
    if (root.val > key)
      root.left = deleteNode(root.left, key);
    else if (root.val < key)
      root.right = deleteNode(root.right, key);
    else {
      if (root.left == null)
        return root.right;
      if (root.right == null)
        return root.left;
      TreeNode node = max(root.left);
      root.val = node.val;
      root.left = deleteNode(root.left, root.val);
    }
    return root;
  }

  TreeNode max(TreeNode node) {
    while (node.right != null)
      node = node.right;
    return node;
  }
}
// @lc code=end

