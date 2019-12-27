/*
 * @lc app=leetcode.cn id=234 lang=java
 *
 * [234] 回文链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
import java.util.ArrayList;

class Solution {
  public boolean isPalindrome(ListNode head) {
    ArrayList<Integer> list = new ArrayList<>();
    ListNode node = head;
    while (node != null) {
      list.add(node.val);
      node = node.next;
    }
    int n = list.size();
    for (int i = 0; i < n / 2; i++)
      if (Integer.compare(list.get(i), list.get(n - 1 - i)) != 0)
        return false;
    return true;
  }
}
// @lc code=end

