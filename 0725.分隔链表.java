/*
 * @lc app=leetcode.cn id=725 lang=java
 *
 * [725] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode current = root;
        int N = 0;
        while (current != null) {
            current = current.next;
            N++;
        }
        int width = N / k, remain = N % k;
        ListNode[] result = new ListNode[k];
        current = root;
        for (int i = 0; i < k; ++i) {
            ListNode head = current;
            for (int j = 0; j < width + (i < remain ? 1 : 0) - 1; ++j) {
                if (current != null)
                    current = current.next;
            }
            if (current != null) {
                ListNode prev = current;
                current = current.next;
                prev.next = null;
            }
            result[i] = head;
        }
        return result;
    }
}
// @lc code=end
