/*
 * @lc app=leetcode.cn id=1171 lang=java
 *
 * [1171] 从链表中删去总和值为零的连续节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
import java.util.HashMap;

class Solution {
  public ListNode removeZeroSumSublists(ListNode head) {
    ListNode pseudo = new ListNode(0);
    pseudo.next = head;
    HashMap<Integer, ListNode> map = new HashMap<>();
    int sum = 0;
    for (ListNode node = pseudo; node != null; node = node.next) {
      sum += node.val;
      map.put(sum, node);
    }
    sum = 0;
    for (ListNode node = pseudo; node != null; node = node.next) {
      sum += node.val;
      node.next = map.get(sum).next;
    }
    return pseudo.next;
  }
}
// @lc code=end

