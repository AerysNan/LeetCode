/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode sortList(ListNode head) {
    return qsort(head);
  }

  ListNode qsort(ListNode head) {
    if (head == null)
      return null;
    int pivot = head.val;
    ListNode pseudoL = new ListNode(-1), pseodoR = new ListNode(-1);
    ListNode current = head.next, currentL = pseudoL, currentR = pseodoR;
    head.next = null;
    while (current != null) {
      if (current.val < pivot) {
        currentL.next = current;
        currentL = currentL.next;
      } else {
        currentR.next = current;
        currentR = currentR.next;
      }
      ListNode tmp = current.next;
      current.next = null;
      current = tmp;
    }
    ListNode l = qsort(pseudoL.next), r = qsort(pseodoR.next);
    if (l == null) {
      head.next = r;
      return head;
    }
    ListNode tail = l;
    while (tail.next != null)
      tail = tail.next;
    tail.next = head;
    head.next = r;
    return l;
  }
}
// @lc code=end

