/*
 * @lc app=leetcode.cn id=257 lang=java
 *
 * [257] 二叉树的所有路径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

class Solution {
  public List<String> binaryTreePaths(TreeNode root) {
    List<String> result = new ArrayList<>();
    if (root == null)
      return result;
    dfs(root, new LinkedList<>(), result);
    return result;
  }

  void dfs(TreeNode node, LinkedList<Integer> current, List<String> result) {
    current.addLast(node.val);
    if (node.left == null && node.right == null) {
      StringJoiner sj = new StringJoiner("->");
      for (int value : current)
        sj.add(String.valueOf(value));
      result.add(sj.toString());
    } else {
      if (node.left != null)
        dfs(node.left, current, result);
      if (node.right != null)
        dfs(node.right, current, result);
    }
    current.pollLast();
  }
}
// @lc code=end

