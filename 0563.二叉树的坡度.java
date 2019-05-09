/*
 * @lc app=leetcode.cn id=563 lang=java
 *
 * [563] 二叉树的坡度
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  private int tilt = 0;

  public int findTilt(TreeNode root) {
    search(root);
    return tilt;
  }

  private int search(TreeNode node) {
    if (node == null)
      return 0;
    int l = search(node.left);
    int r = search(node.right);
    tilt += Math.abs(l - r);
    return l + r + node.val;
  }
}
