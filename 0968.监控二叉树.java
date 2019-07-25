import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=968 lang=java
 *
 * [968] 监控二叉树
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */

class Solution {
  int result = 0;
  HashMap<TreeNode, Integer> status = new HashMap<>();

  public int minCameraCover(TreeNode root) {
    if (root == null)
      return 0;
    if (traverse(root) == 0)
      result++;
    return result;
  }

  int traverse(TreeNode node) {
    if (node == null)
      return -1;
    int L = traverse(node.left);
    int R = traverse(node.right);
    if (L == 0 || R == 0) {
      result++;
      return 1;
    } else if (L == 1 || R == 1)
      return 2;
    else
      return 0;
  }
}
