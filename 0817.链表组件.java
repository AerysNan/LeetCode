/*
 * @lc app=leetcode.cn id=817 lang=java
 *
 * [817] 链表组件
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
import java.util.HashSet;

class Solution {
  public int numComponents(ListNode head, int[] G) {
    int result = 0;
    boolean current = false;
    HashSet<Integer> set = new HashSet<>();
    for (int g : G)
      set.add(g);
    while (head != null) {
      if (set.contains(head.val)) {
        if (!current) {
          current = true;
          result++;
        }
      } else
        current = false;
      head = head.next;
    }
    return result;
  }
}
// @lc code=end
