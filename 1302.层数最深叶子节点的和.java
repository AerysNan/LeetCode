/*
 * @lc app=leetcode.cn id=1302 lang=java
 *
 * [1302] 层数最深叶子节点的和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;

class Solution {

  public int deepestLeavesSum(TreeNode root) {
    if (root == null)
      return 0;
    int result = 0;
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int n = queue.size();
      result = 0;
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.poll();
        result += node.val;
        if (node.left != null)
          queue.offer(node.left);
        if (node.right != null)
          queue.offer(node.right);
      }
    }
    return result;
  }
}
// @lc code=end
