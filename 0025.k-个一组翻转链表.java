import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
 */
class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    ListNode fakeHead = new ListNode(-1);
    LinkedList<ListNode> list = new LinkedList<>();
    ListNode currentNode = head, linkNode = fakeHead;
    int cnt = 0;
    while (currentNode != null) {
      ListNode tmp = currentNode;
      list.addLast(currentNode);
      currentNode = currentNode.next;
      tmp.next = null;
      cnt++;
      if (cnt == k) {
        cnt = 0;
        for (int i = 0; i < k; i++) {
          linkNode.next = list.pollLast();
          linkNode = linkNode.next;
        }
      }
    }
    while (!list.isEmpty()) {
      linkNode.next = list.pollFirst();
      linkNode = linkNode.next;
    }
    return fakeHead.next;
  }
}
