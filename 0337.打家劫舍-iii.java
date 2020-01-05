/*
 * @lc app=leetcode.cn id=337 lang=java
 *
 * [337] 打家劫舍 III
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import javafx.util.Pair;

class Solution {
  public int rob(TreeNode root) {
    Pair<Integer, Integer> p = solve(root);
    return Math.max(p.getKey(), p.getValue());
  }

  Pair<Integer, Integer> solve(TreeNode node) {
    if (node == null)
      return new Pair<>(0, 0);
    Pair<Integer, Integer> pl = solve(node.left), pr = solve(node.right);
    return new Pair<>(pl.getValue() + pr.getValue() + node.val,
        Math.max(pl.getKey(), pl.getValue()) + Math.max(pr.getKey(), pr.getValue()));
  }
}
// @lc code=end

