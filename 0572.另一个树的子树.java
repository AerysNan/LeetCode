/*
 * @lc app=leetcode.cn id=572 lang=java
 *
 * [572] 另一个树的子树
 */
class Solution {
  public boolean isSubtree(TreeNode s, TreeNode t) {
    if (s == null)
      return false;
    return match(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
  }

  private boolean match(TreeNode s, TreeNode t) {
    if (s == null && t == null)
      return true;
    if (s == null || t == null || s.val != t.val)
      return false;
    return match(s.left, t.left) && match(s.right, t.right);
  }
}
