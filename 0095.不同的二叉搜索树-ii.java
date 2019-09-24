/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}


class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0)
      return new ArrayList<>();
    return build(1, n);
  }

  List<TreeNode> build(int l, int r) {
    List<TreeNode> result = new ArrayList<>();
    if (l > r)
      return Arrays.asList(new TreeNode[] {null});
    for (int i = l; i <= r; i++) {
      List<TreeNode> lTree = build(l, i - 1);
      List<TreeNode> rTree = build(i + 1, r);
      for (TreeNode lNode : lTree) {
        for (TreeNode rNode : rTree) {
          TreeNode root = new TreeNode(i);
          root.left = lNode;
          root.right = rNode;
          result.add(root);
        }
      }
    }
    return result;
  }
}
// @lc code=end

