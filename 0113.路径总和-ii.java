/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
  List<List<Integer>> result;

  public List<List<Integer>> pathSum(TreeNode root, int sum) {
    result = new ArrayList<>();
    if (root == null)
      return result;
    search(root, sum, new LinkedList<>());
    return result;
  }

  private void search(TreeNode node, int val, LinkedList<Integer> current) {
    if (node.left == null && node.right == null && val == node.val) {
      current.addLast(node.val);
      result.add(new LinkedList<>(current));
      current.pollLast();
      return;
    }
    if (node.left != null) {
      current.addLast(node.val);
      search(node.left, val - node.val, current);
      current.pollLast();
    }
    if (node.right != null) {
      current.addLast(node.val);
      search(node.right, val - node.val, current);
      current.pollLast();
    }
  }
}
// @lc code=end

