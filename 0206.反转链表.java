/*
 * @lc app=leetcode.cn id=206 lang=java
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
import java.util.LinkedList;

class Solution {
  public ListNode reverseList(ListNode head) {
    LinkedList<ListNode> stack = new LinkedList<>();
    ListNode current = head;
    while (current != null) {
      ListNode next = current.next;
      current.next = null;
      stack.addLast(current);
      current = next;
    }
    if (stack.isEmpty())
      return null;
    ListNode result = stack.pollLast();
    current = result;
    while (!stack.isEmpty()) {
      ListNode node = stack.pollLast();
      current.next = node;
      current = current.next;
    }
    return result;
  }
}
// @lc code=end

