import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=143 lang=java
 *
 * [143] 重排链表
 */

class Solution {
  public void reorderList(ListNode head) {
    if (head == null || head.next == null)
      return;
    LinkedList<ListNode> list = new LinkedList<>();
    int length = 0;
    ListNode node = head;
    while (node != null) {
      length++;
      node = node.next;
    }
    int half = (length + 1) / 2;
    ListNode fTail = head;
    for (int i = 0; i < half - 1; i++)
      fTail = fTail.next;
    ListNode sHead = fTail.next;
    fTail.next = null;
    while (sHead != null) {
      ListNode tmp = sHead.next;
      sHead.next = null;
      list.addLast(sHead);
      sHead = tmp;
    }
    ListNode currentNode = list.pollLast();
    sHead = currentNode;
    while (!list.isEmpty()) {
      ListNode tmp = list.pollLast();
      currentNode.next = tmp;
      currentNode = tmp;
    }
    currentNode.next = null;
    ListNode p1 = head, p2 = sHead;
    while (p1 != null && p2 != null) {
      ListNode next1 = p1.next;
      ListNode next2 = p2.next;
      p1.next = p2;
      p2.next = next1;
      p1 = next1;
      p2 = next2;
    }
  }
}
