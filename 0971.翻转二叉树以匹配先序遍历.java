/*
 * @lc app=leetcode.cn id=971 lang=java
 *
 * [971] 翻转二叉树以匹配先序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
  ArrayList<Integer> result = new ArrayList<>();
  int index = 0, invalid = 0;
  int[] voyage;

  public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
    this.voyage = voyage;
    dfs(root);
    if (invalid > 0) {
      result.clear();
      result.add(-1);
    }
    return result;
  }

  public void dfs(TreeNode node) {
    if (node == null)
      return;
    if (node.val != voyage[index++]) {
      invalid = 1;
      return;
    }
    if (index < voyage.length && node.left != null && node.left.val != voyage[index]) {
      result.add(node.val);
      dfs(node.right);
      dfs(node.left);
    } else {
      dfs(node.left);
      dfs(node.right);
    }
  }
}

// @lc code=end
