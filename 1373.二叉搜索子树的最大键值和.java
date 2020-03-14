/*
 * @lc app=leetcode.cn id=1373 lang=java
 *
 * [1373] 二叉搜索子树的最大键值和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  int result = 0;

  public int maxSumBST(TreeNode root) {
    dfs(root);
    return result;
  }

  Pair<Integer, Boolean> dfs(TreeNode node) {
    if (node == null)
      return new Pair<>(0, true);
    Pair<Integer, Boolean> l = dfs(node.left), r = dfs(node.right);
    int sum = l.getKey() + r.getKey() + node.val;
    boolean valid =
        l.getValue() && r.getValue() && (node.right == null || node.val < node.right.val)
            && (node.left == null || node.val > node.left.val);
    if (valid)
      result = Math.max(result, sum);
    return new Pair<>(sum, valid);
  }
}
// @lc code=end

