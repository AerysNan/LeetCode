/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode partition(ListNode head, int x) {
    ListNode fake1 = new ListNode(-1), fake2 = new ListNode(-1);
    ListNode current = head, current1 = fake1, current2 = fake2;
    while (current != null) {
      if (current.val < x) {
        current1.next = current;
        current1 = current1.next;
      } else {
        current2.next = current;
        current2 = current2.next;
      }
      ListNode tmp = current.next;
      current.next = null;
      current = tmp;

    }
    if (fake1.next == null)
      return fake2.next;
    current1.next = fake2.next;
    return fake1.next;
  }
}
// @lc code=end

