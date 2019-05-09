/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode node1 = l1, node2 = l2;
    ListNode headNode = new ListNode(-1);
    ListNode pendingNode = headNode;
    int carry = 0;
    while (true) {
      if (node1 == null && node2 == null)
        break;
      int val1 = node1 == null ? 0 : node1.val;
      int val2 = node2 == null ? 0 : node2.val;
      ListNode newNode = new ListNode((val1 + val2 + carry) % 10);
      carry = (val1 + val2 + carry) / 10;
      pendingNode.next = newNode;
      pendingNode = newNode;
      node1 = node1 == null ? node1 : node1.next;
      node2 = node2 == null ? node2 : node2.next;
    }
    if (carry != 0) {
      ListNode newNode = new ListNode(carry);
      pendingNode.next = newNode;
    }
    return headNode.next;
  }
}
