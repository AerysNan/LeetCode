/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; next = null; } }
 */
public class Solution {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    int lengthA = length(headA), lengthB = length(headB);
    ListNode currentA = headA, currentB = headB;
    if (lengthA > lengthB)
      for (int i = 0; i < lengthA - lengthB; i++)
        currentA = currentA.next;
    else
      for (int i = 0; i < lengthB - lengthA; i++)
        currentB = currentB.next;
    while (currentA != null) {
      if (currentA == currentB)
        return currentA;
      currentA = currentA.next;
      currentB = currentB.next;
    }
    return null;
  }

  private static int length(ListNode head) {
    int result = 0;
    ListNode current = head;
    while (current != null) {
      result++;
      current = current.next;
    }
    return result;
  }
}
// @lc code=end

