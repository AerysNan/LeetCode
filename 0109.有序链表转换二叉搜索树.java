/*
 * @lc app=leetcode.cn id=109 lang=java
 *
 * [109] 有序链表转换二叉搜索树
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
  public TreeNode sortedListToBST(ListNode head) {
    if (head == null)
      return null;
    return build(head, null);
  }

  TreeNode build(ListNode head, ListNode tail) {
    if (head == tail)
      return null;
    ListNode slow = head, fast = head;
    while (fast != tail && fast.next != tail) {
      fast = fast.next.next;
      slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.left = build(head, slow);
    root.right = build(slow.next, tail);
    return root;
  }
}
// @lc code=end

