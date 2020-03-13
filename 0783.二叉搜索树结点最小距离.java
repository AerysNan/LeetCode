/*
 * @lc app=leetcode.cn id=783 lang=java
 *
 * [783] 二叉搜索树结点最小距离
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;

class Solution {
  ArrayList<Integer> list = new ArrayList<>();

  public int minDiffInBST(TreeNode root) {
    search(root);
    int result = Integer.MAX_VALUE;
    for (int i = 1; i < list.size(); i++)
      result = Math.min(result, Math.abs(list.get(i) - list.get(i - 1)));
    return result;
  }

  void search(TreeNode node) {
    if (node == null)
      return;
    search(node.left);
    list.add(node.val);
    search(node.right);
  }
}
// @lc code=end

