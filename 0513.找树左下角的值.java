/*
 * @lc app=leetcode.cn id=513 lang=java
 *
 * [513] 找树左下角的值
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.LinkedList;

class Solution {
  public int findBottomLeftValue(TreeNode root) {
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int result = -1;
    while (!queue.isEmpty()) {
      int size = queue.size();
      result = queue.peekLast().val;
      for (int i = 0; i < size; i++) {
        TreeNode node = queue.pollLast();
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

