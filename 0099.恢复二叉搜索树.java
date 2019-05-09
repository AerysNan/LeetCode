/*
 * @lc app=leetcode.cn id=99 lang=java
 *
 * [99] 恢复二叉搜索树
 */
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  private TreeNode current;
  private TreeNode prev;
  private TreeNode tmp;
  private TreeNode n1, n2;

  public void recoverTree(TreeNode root) {
    current = root;
    while (current != null) {
      if (current.left == null) {
        check();
        current = current.right;
      } else {
        tmp = current.left;
        while (tmp.right != null && tmp.right != current)
          tmp = tmp.right;
        if (tmp.right == null) {
          tmp.right = current;
          current = current.left;
        } else if (tmp.right == current) {
          tmp.right = null;
          check();
          current = current.right;
        }
      }
    }
    int tmp = n1.val;
    n1.val = n2.val;
    n2.val = tmp;
  }

  private void check() {
    if (prev != null && prev.val > current.val) {
      if (n1 == null)
        n1 = prev;
      n2 = current;
    }
    tmp = current;
    prev = current;
  }
}
