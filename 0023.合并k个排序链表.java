import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 */
class Solution {
  private PriorityQueue<ListNode> queue;

  private static Comparator<ListNode> listNodeComparator = new Comparator<ListNode>() {
    @Override
    public int compare(ListNode n1, ListNode n2) {
      if (n1.val < n2.val)
        return -1;
      if (n1.val > n2.val)
        return 1;
      return 0;
    }
  };

  public ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0)
      return null;
    queue = new PriorityQueue<>(lists.length, listNodeComparator);
    ListNode head = new ListNode(-1), currentNode = head;
    for (ListNode list : lists)
      if (list != null)
        queue.add(list);
    while (!queue.isEmpty()) {
      ListNode node = queue.poll();
      if (node.next != null)
        queue.add(node.next);
      ListNode newNode = new ListNode(node.val);
      currentNode.next = newNode;
      currentNode = newNode;
    }
    return head.next;
  }
}
