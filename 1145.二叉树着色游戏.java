/*
 * @lc app=leetcode.cn id=1145 lang=java
 *
 * [1145] 二叉树着色游戏
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
  TreeNode target = null;

  public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
    search(root, x);
    if (target == root) {
      int size = getTreeSize(root.left);
      return size * 2 != n - 1;
    }
    int leftSize = getTreeSize(target.left), rightSize = getTreeSize(target.right);
    int totalSize = leftSize + rightSize + 1;
    return totalSize * 2 < n || leftSize * 2 > n || rightSize * 2 > n;
  }

  private int getTreeSize(TreeNode node) {
    if (node == null)
      return 0;
    System.out.print(node.val + " ");
    return 1 + getTreeSize(node.left) + getTreeSize(node.right);
  }

  private boolean search(TreeNode node, int value) {
    if (node == null)
      return false;
    if (node.val == value) {
      target = node;
      return true;
    }
    if (!search(node.left, value))
      return search(node.right, value);
    return true;
  }
}
