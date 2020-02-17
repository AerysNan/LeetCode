/*
 * @lc app=leetcode.cn id=445 lang=java
 *
 * [445] 两数相加 II
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
import java.util.Stack;

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    Stack<Integer> s1 = new Stack<>(), s2 = new Stack<>(), s = new Stack<>();
    ListNode current = l1;
    while (current != null) {
      s1.push(current.val);
      current = current.next;
    }
    current = l2;
    while (current != null) {
      s2.push(current.val);
      current = current.next;
    }
    int carry = 0;
    while (!s1.isEmpty() && !s2.isEmpty()) {
      int value = carry + s1.pop() + s2.pop();
      s.push(value % 10);
      carry = value / 10;
    }
    while (!s1.isEmpty()) {
      int value = carry + s1.pop();
      s.push(value % 10);
      carry = value / 10;
    }
    while (!s2.isEmpty()) {
      int value = carry + s2.pop();
      s.push(value % 10);
      carry = value / 10;
    }
    if (carry != 0)
      s.push(carry);
    ListNode pseudo = new ListNode(0);
    current = pseudo;
    while (!s.isEmpty()) {
      ListNode node = new ListNode(s.pop());
      current.next = node;
      current = current.next;
    }
    return pseudo.next;
  }
}
// @lc code=end

