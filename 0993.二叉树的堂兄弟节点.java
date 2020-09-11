/*
 * @lc app=leetcode.cn id=993 lang=java
 *
 * [993] 二叉树的堂兄弟节点
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
import java.util.HashMap;

class Solution {
  HashMap<Integer, Integer> depth;
  HashMap<Integer, TreeNode> parent;

  public boolean isCousins(TreeNode root, int x, int y) {
    depth = new HashMap<>();
    parent = new HashMap<>();
    dfs(root, null, 0);
    return (depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y));
  }

  public void dfs(TreeNode node, TreeNode p, int d) {
    if (node == null)
      return;
    depth.put(node.val, d);
    parent.put(node.val, p);
    dfs(node.left, node, d + 1);
    dfs(node.right, node, d + 1);
  }
}
// @lc code=end
