/*
 * @lc app=leetcode.cn id=637 lang=java
 *
 * [637] 二叉树的层平均值
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
  public List<Double> averageOfLevels(TreeNode root) {
    ArrayList<Double> result = new ArrayList<>();
    if (root == null)
      return result;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      double sum = 0;
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
        sum += node.val;
        if (node.left != null)
          queue.addFirst(node.left);
        if (node.right != null)
          queue.addFirst(node.right);
      }
      result.add(sum / size);
    }
    return result;
  }
}
// @lc code=end

