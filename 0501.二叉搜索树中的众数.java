/*
 * @lc app=leetcode.cn id=501 lang=java
 *
 * [501] 二叉搜索树中的众数
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;

class Solution {
  ArrayList<Integer> modes = new ArrayList<>();
  int count = 0, max = 0, prev = Integer.MIN_VALUE;

  public int[] findMode(TreeNode root) {
    traverse(root);
    int[] result = new int[modes.size()];
    for (int i = 0; i < modes.size(); i++)
      result[i] = modes.get(i);
    return result;
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    traverse(node.left);
    if (prev == node.val)
      count++;
    else {
      count = 1;
    }
    if (count > max) {
      modes.clear();
      modes.add(node.val);
      max = count;
    } else if (count == max)
      modes.add(node.val);
    prev = node.val;
    traverse(node.right);
  }

}
// @lc code=end

