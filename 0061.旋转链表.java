/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
 */
class Solution {
  public ListNode rotateRight(ListNode head, int k) {
    if (head == null)
      return null;
    ListNode node = head;
    int length = 1;
    while (node.next != null) {
      length++;
      node = node.next;
    }
    k %= length;
    if (k == 0)
      return head;
    node.next = head;
    node = head;
    for (int i = 0; i < length - k - 1; i++)
      node = node.next;
    ListNode result = node.next;
    node.next = null;
    return result;
  }
}
