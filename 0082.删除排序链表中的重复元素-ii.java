/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
class Solution {
  public ListNode deleteDuplicates(ListNode head) {
    ListNode fake = new ListNode(-1);
    ListNode tail = fake;
    ListNode current = head;
    while (current != null) {
      ListNode node = current;
      while (node != null && node.val == current.val)
        node = node.next;
      if (node == current.next) {
        tail.next = new ListNode(current.val);
        tail = tail.next;
      }
      current = node;
    }
    return fake.next;
  }
}
// @lc code=end

