/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
import java.util.Optional;
import javafx.util.Pair;

class Solution {
  public boolean isValidBST(TreeNode root) {
    if (root == null)
      return true;
    return traverse(root).isPresent();
  }

  Optional<Pair<Integer, Integer>> traverse(TreeNode node) {
    int minValue = node.val, maxValue = node.val;
    if (node.left != null) {
      Optional<Pair<Integer, Integer>> option = traverse(node.left);
      if (!option.isPresent())
        return Optional.empty();
      int lMin = option.get().getKey(), lMax = option.get().getValue();
      if (lMax >= node.val)
        return Optional.empty();
      minValue = lMin;
    }
    if (node.right != null) {
      Optional<Pair<Integer, Integer>> option = traverse(node.right);
      if (!option.isPresent())
        return Optional.empty();
      int rMin = option.get().getKey(), rMax = option.get().getValue();
      if (rMin <= node.val)
        return Optional.empty();
      maxValue = rMax;
    }
    return Optional.of(new Pair<>(minValue, maxValue));
  }
}
// @lc code=end
