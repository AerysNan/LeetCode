import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第N个节点
 */
class Solution {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    ArrayList<ListNode> list = new ArrayList<>();
    ListNode current = head;
    while (current != null) {
      list.add(current);
      current = current.next;
    }
    if (n == list.size())
      return head.next;
    list.get(list.size() - n - 1).next = list.get(list.size() - n).next;
    return head;
  }
}
