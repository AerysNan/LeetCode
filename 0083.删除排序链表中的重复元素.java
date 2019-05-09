/*
 * @lc app=leetcode.cn id=83 lang=java
 *
 * [83] 删除排序链表中的重复元素
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null) {
      ListNode tmp = current;
      while (tmp.next != null && tmp.val == tmp.next.val)
        tmp = tmp.next;
      current.next = tmp.next;
      current = current.next;
    }
    return head;
  }
}
