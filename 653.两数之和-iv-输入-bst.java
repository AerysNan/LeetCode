/*
 * @lc app=leetcode.cn id=653 lang=java
 *
 * [653] 两数之和 IV - 输入 BST
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;

class Solution {
  ArrayList<Integer> list = new ArrayList<>();

  public boolean findTarget(TreeNode root, int k) {
    traverse(root);
    int l = 0, r = list.size() - 1;
    while (l < r) {
      int sum = list.get(l) + list.get(r);
      if (sum == k)
        return true;
      if (sum > k)
        r--;
      else
        l++;
    }
    return false;
  }

  void traverse(TreeNode node) {
    if (node == null)
      return;
    traverse(node.left);
    list.add(node.val);
    traverse(node.right);
  }
}
// @lc code=end

