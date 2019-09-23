/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
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
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    TreeNode node = root;
    LinkedList<TreeNode> stack = new LinkedList<>();
    while (!stack.isEmpty() || node != null) {
      while (node != null) {
        stack.addLast(node);
        node = node.left;
      }
      TreeNode current = stack.pollLast();
      result.add(current.val);
      node = current.right;
    }
    return result;
  }
}
// @lc code=end

