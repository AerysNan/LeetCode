import java.util.Iterator;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1019 lang=java
 *
 * [1019] 链表中的下一个更大节点
 */
class Solution {
  public int[] nextLargerNodes(ListNode head) {
    LinkedList<int[]> list = new LinkedList<>();
    ListNode node = head;
    int size = 0;
    while (node != null) {
      size++;
      node = node.next;
    }
    int[] result = new int[size];
    node = head;
    int index = 0;
    while (node != null) {
      int value = node.val;
      while (!list.isEmpty() && list.peekLast()[0] < value)
        result[list.pollLast()[1]] = value;
      list.addLast(new int[] { value, index });
      node = node.next;
      index++;
    }
    while (!list.isEmpty())
      result[list.pollLast()[1]] = 0;
    return result;
  }
}
