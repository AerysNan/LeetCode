import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个排序链表
 *
 * https://leetcode-cn.com/problems/merge-k-sorted-lists/description/
 *
 * algorithms
 * Hard (43.11%)
 * Total Accepted:    14.1K
 * Total Submissions: 32.4K
 * Testcase Example:  '[[1,4,5],[1,3,4],[2,6]]'
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 *
 * 输入:
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 *
 */
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
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
