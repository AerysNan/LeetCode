/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层次遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
  public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;
    boolean forward = true;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      LinkedList<Integer> output = new LinkedList<>();
      LinkedList<TreeNode> newQueue = new LinkedList<>();
      while (!queue.isEmpty()) {
        TreeNode node = queue.pollLast();
        if (forward)
          output.addLast(node.val);
        else
          output.addFirst(node.val);
        if (node.left != null)
          newQueue.addFirst(node.left);
        if (node.right != null)
          newQueue.addFirst(node.right);
      }
      result.add(output);
      queue = newQueue;
      forward = !forward;
    }
    return result;
  }
}
// @lc code=end

