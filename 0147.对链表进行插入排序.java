/*
 * @lc app=leetcode.cn id=147 lang=java
 *
 * [147] 对链表进行插入排序
 */
class Solution {
  public ListNode insertionSortList(ListNode head) {
    if (head == null)
      return head;
    ListNode result = new ListNode(head.val);
    ListNode node = head.next;
    while (node != null) {
      ListNode nextNode = node.next;
      if (node.val < result.val) {
        node.next = result;
        result = node;
      } else {
        ListNode insertNode = find(result, node.val);
        node.next = insertNode.next;
        insertNode.next = node;
      }
      node = nextNode;
    }
    return result;
  }

  ListNode find(ListNode head, int value) {
    if (value < head.val)
      return null;
    ListNode node = head;
    while (node.next != null) {
      if (value < node.next.val)
        break;
      node = node.next;
    }
    return node;
  }
}
