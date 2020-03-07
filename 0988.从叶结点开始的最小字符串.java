/*
 * @lc app=leetcode.cn id=988 lang=java
 *
 * [988] 从叶结点开始的最小字符串
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  String result = "~";

  public String smallestFromLeaf(TreeNode root) {
    dfs(root, new StringBuilder());
    return result;
  }

  public void dfs(TreeNode node, StringBuilder sb) {
    if (node == null)
      return;
    sb.append((char) ('a' + node.val));
    if (node.left == null && node.right == null) {
      String string = sb.reverse().toString();
      sb.reverse();
      if (string.compareTo(result) < 0)
        result = string;
    }
    dfs(node.left, sb);
    dfs(node.right, sb);
    sb.deleteCharAt(sb.length() - 1);
  }
}
// @lc code=end

