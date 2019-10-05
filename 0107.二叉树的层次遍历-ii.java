/*
 * @lc app=leetcode.cn id=107 lang=java
 *
 * [107] 二叉树的层次遍历 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> levelOrderBottom(TreeNode root) {
    LinkedList<List<Integer>> result = new LinkedList<>();
    if (root == null)
      return result;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      LinkedList<Integer> output = new LinkedList<>();
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
        output.add(node.val);
        if (node.left != null)
          queue.addFirst(node.left);
        if (node.right != null)
          queue.addFirst(node.right);
      }
      result.addFirst(output);
    }
    return (List<List<Integer>>) result;
  }
}
// @lc code=end

