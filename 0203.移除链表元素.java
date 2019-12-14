/*
 * @lc app=leetcode.cn id=203 lang=java
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode removeElements(ListNode head, int val) {
    if (head == null)
      return null;
    while (head != null && head.val == val)
      head = head.next;
    ListNode current = head;
    while (current != null) {
      ListNode node = current.next;
      while (node != null && node.val == val)
        node = node.next;
      current.next = node;
      current = node;
    }
    return head;
  }
}
// @lc code=end

