/*
 * @lc app=leetcode.cn id=21 lang=java
 *
 * [21] 合并两个有序链表
 */

class Solution {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode n1 = l1, n2 = l2;
    ListNode fakeHead = new ListNode(-1), currentNode = fakeHead;
    while (n1 != null && n2 != null) {
      if (n1.val < n2.val) {
        currentNode.next = n1;
        currentNode = n1;
        n1 = n1.next;
      } else {
        currentNode.next = n2;
        currentNode = n2;
        n2 = n2.next;
      }
    }
    while (n1 != null) {
      currentNode.next = n1;
      currentNode = n1;
      n1 = n1.next;
    }
    while (n2 != null) {
      currentNode.next = n2;
      currentNode = n2;
      n2 = n2.next;
    }
    return fakeHead.next;
  }
}
