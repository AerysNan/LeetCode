/*
 * @lc app=leetcode.cn id=382 lang=java
 *
 * [382] 链表随机节点
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int
 * x) { val = x; } }
 */
import java.util.Random;

class Solution {

  /**
   * @param head The linked list's head. Note that the head is guaranteed to be not null, so it
   *             contains at least one node.
   */

  Random random;
  ListNode head;

  public Solution(ListNode head) {
    this.random = new Random();
    this.head = head;
  }

  /** Returns a random node's value. */
  public int getRandom() {
    int count = 1;
    ListNode result = head, current = head;
    while (current != null) {
      if (random.nextInt(count++) == 0)
        result = current;
      current = current.next;
    }
    return result.val;
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
// @lc code=end

