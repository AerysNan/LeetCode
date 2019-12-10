/*
 * @lc app=leetcode.cn id=199 lang=java
 *
 * [199] 二叉树的右视图
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
  public List<Integer> rightSideView(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null)
      return result;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
        if (i + 1 == size)
          result.add(node.val);
        if (node.left != null)
          queue.addFirst(node.left);
        if (node.right != null)
          queue.addFirst(node.right);
      }
    }
    return result;
  }
}
// @lc code=end

