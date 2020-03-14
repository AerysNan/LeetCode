/*
 * @lc app=leetcode.cn id=1367 lang=java
 *
 * [1367] 二叉树中的列表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode
 * right; TreeNode(int x) { val = x; } }
 */
class Solution {
  public boolean isSubPath(ListNode head, TreeNode root) {
    if (head == null)
      return true;
    if (root == null)
      return false;
    return match(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
  }

  boolean match(ListNode head, TreeNode root) {
    if (head == null)
      return true;
    if (root == null || root.val != head.val)
      return false;
    return match(head.next, root.left) || match(head.next, root.right);
  }
}
// @lc code=end

