/*
 * @lc app=leetcode.cn id=24 lang=java
 *
 * [24] 两两交换链表中的节点
 */

class Solution {
  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null)
      return head;
    ListNode fakeHead = new ListNode(-1), prev = fakeHead;
    fakeHead.next = head;
    ListNode n1 = head, n2 = head.next;
    while (n1 != null && n2 != null) {
      n1.next = n2.next;
      n2.next = n1;
      prev.next = n2;
      prev = n1;
      n1 = n1.next;
      if (n1 == null)
        break;
      n2 = n1.next;
    }
    return fakeHead.next;
  }
}