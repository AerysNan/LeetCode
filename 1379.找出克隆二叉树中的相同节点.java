/*
 * @lc app=leetcode.cn id=1379 lang=java
 *
 * [1379] 找出克隆二叉树中的相同节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;

class Solution {
  LinkedList<Boolean> action;

  public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned,
      final TreeNode target) {
    dfs(original, target, new LinkedList<>());
    TreeNode result = cloned;
    for (boolean a : action) {
      if (a)
        result = result.left;
      else
        result = result.right;
    }
    return result;
  }

  void dfs(final TreeNode node, final TreeNode target, LinkedList<Boolean> list) {
    if (node == target) {
      action = new LinkedList<>(list);
      return;
    }
    if (node.left != null) {
      list.addLast(true);
      dfs(node.left, target, list);
      list.pollLast();
    }
    if (node.right != null) {
      list.addLast(false);
      dfs(node.right, target, list);
      list.pollLast();
    }
  }
}
// @lc code=end

