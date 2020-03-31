/*
 * @lc app=leetcode.cn id=1161 lang=java
 *
 * [1161] 最大层内元素和
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;
import java.util.LinkedList;

class Solution {
  public int maxLevelSum(TreeNode root) {
    ArrayList<Integer> sums = new ArrayList<>();
    LinkedList<TreeNode> queue = new LinkedList<>();
    queue.addFirst(root);
    while (!queue.isEmpty()) {
      int n = queue.size(), sum = 0;
      for (int i = 0; i < n; i++) {
        TreeNode node = queue.pollLast();
        sum += node.val;
        if (node.left != null)
          queue.addFirst(node.left);
        if (node.right != null)
          queue.addFirst(node.right);
      }
      sums.add(sum);
    }
    int result = -1;
    for (int i = 0; i < sums.size(); i++)
      if (result < 0 || sums.get(result) < sums.get(i))
        result = i;
    return result + 1;
  }
}
// @lc code=end

