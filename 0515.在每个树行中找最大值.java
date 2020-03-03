/*
 * @lc app=leetcode.cn id=515 lang=java
 *
 * [515] 在每个树行中找最大值
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
  public List<Integer> largestValues(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    ArrayList<Integer> result = new ArrayList<>();
    if (root == null)
      return result;
    queue.add(root);
    while (!queue.isEmpty()) {
      int size = queue.size(), max = Integer.MIN_VALUE;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
        max = Math.max(max, node.val);
        if (node.left != null)
          queue.addFirst(node.left);
        if (node.right != null)
          queue.addFirst(node.right);
      }
      result.add(max);
    }
    return result;
  }
}
// @lc code=end

