/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] 二叉树的直径
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public int diameterOfBinaryTree(TreeNode root) {
    return search(root).getKey();
  }

  Pair<Integer, Integer> search(TreeNode node) {
    if (node == null)
      return new Pair<>(0, -1);
    Pair<Integer, Integer> l = search(node.left), r = search(node.right);
    System.out.println(node.val + " " + l.toString() + r.toString());
    int d = Math.max(Math.max(l.getKey(), r.getKey()), l.getValue() + r.getValue() + 2);
    int c = Math.max(l.getValue(), r.getValue()) + 1;
    return new Pair<>(d, c);
  }
}
// @lc code=end

