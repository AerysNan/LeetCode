/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 *
 * https://leetcode-cn.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (32.55%)
 * Total Accepted:    85.3K
 * Total Submissions: 261.8K
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
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
