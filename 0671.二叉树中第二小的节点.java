/*
 * @lc app=leetcode.cn id=671 lang=java
 *
 * [671] 二叉树中第二小的节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.Stack;

class Solution {
  Integer v1, v2;

  public int findSecondMinimumValue(TreeNode root) {
    traverse(root);
    return v2 == null ? -1 : v2;
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    traverse(node.left);
    if (v1 == null)
      v1 = node.val;
    else if (v1 > node.val) {
      v2 = v1;
      v1 = node.val;
    } else if (v1 < node.val) {
      if (v2 == null)
        v2 = node.val;
      else if (v2 > node.val)
        v2 = node.val;
    }
    traverse(node.right);
  }
}
// @lc code=end

