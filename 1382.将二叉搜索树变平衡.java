/*
 * @lc app=leetcode.cn id=5179 lang=java
 *
 * [5179] 将二叉搜索树变平衡
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
import java.util.ArrayList;

class Solution {
  ArrayList<Integer> list = new ArrayList<>();

  public TreeNode balanceBST(TreeNode root) {
    search(root);
    int n = list.size();
    if (n == 0)
      return null;
    TreeNode newRoot = new TreeNode(list.get(n / 2));
    newRoot.left = build(0, n / 2 - 1);
    newRoot.right = build(n / 2 + 1, n - 1);
    return newRoot;
  }

  void search(TreeNode node) {
    if (node == null)
      return;
    search(node.left);
    list.add(node.val);
    search(node.right);
  }

  TreeNode build(int l, int r) {
    if (l > r)
      return null;
    if (l == r)
      return new TreeNode(list.get(l));
    int mid = (l + r) / 2;
    TreeNode node = new TreeNode(list.get(mid));
    node.left = build(l, mid - 1);
    node.right = build(mid + 1, r);
    return node;
  }
}
// @lc code=end

