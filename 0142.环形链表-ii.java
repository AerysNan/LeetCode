/*
 * @lc app=leetcode.cn id=142 lang=java
 *
 * [142] 环形链表 II
 */
public class Solution {
  public ListNode detectCycle(ListNode head) {
    ListNode s = head, f = head;
    while (true) {
      if (s == null || f == null || f.next == null)
        return null;
      s = s.next;
      f = f.next.next;
      if (s == f)
        break;
    }
    ListNode d = s;
    int n = 0;
    while (true) {
      d = d.next;
      n++;
      if (d == s)
        break;
    }
    s = head;
    f = head;
    for (int i = 0; i < n; i++)
      f = f.next;
    while (s != f) {
      s = s.next;
      f = f.next;
    }
    return s;
  }
}
