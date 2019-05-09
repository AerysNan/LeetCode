/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */
public class Solution {
  public boolean hasCycle(ListNode head) {
    if (head == null)
      return false;
    if (head.next == head)
      return true;
    ListNode node1 = head, node2 = head;
    while (true) {
      if (node1 == null || node2 == null)
        return false;
      node1 = node1.next;
      node2 = node2.next;
      if (node2 == null)
        return false;
      node2 = node2.next;
      if (node1 == node2)
        return true;
    }
  }
}
