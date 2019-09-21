/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    ListNode fake = new ListNode(-1);
    ListNode l = fake;
    fake.next = head;
    for (int i = 0; i < m - 1; i++)
      l = l.next;
    ListNode r = l.next, tail = null, con = l.next;
    for (int i = 0; i <= n - m; i++) {
      ListNode tmp = r.next;
      r.next = tail;
      tail = r;
      r = tmp;
    }
    con.next = r;
    l.next = tail;
    return fake.next;
  }
}
// @lc code=end

