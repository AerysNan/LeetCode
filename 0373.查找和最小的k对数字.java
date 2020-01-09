/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的K对数字
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
  public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    List<List<Integer>> result = new ArrayList<>();
    if (nums1.length == 0 || nums2.length == 0 || k == 0)
      return result;
    PriorityQueue<List<Integer>> queue =
        new PriorityQueue<>((a, b) -> Integer.compare(a.get(0) + a.get(1), b.get(0) + b.get(1)));
    for (int i = 0; i < nums1.length && i < k; i++) {
      List<Integer> list = new ArrayList<>();
      list.add(nums1[i]);
      list.add(nums2[0]);
      list.add(0);
      queue.offer(list);
    }
    while (!queue.isEmpty() && k-- > 0) {
      List<Integer> current = queue.poll();
      List<Integer> list = new ArrayList<>();
      list.add(current.get(0));
      list.add(current.get(1));
      result.add(list);
      if (current.get(2) + 1 == nums2.length)
        continue;
      List<Integer> next = new ArrayList<>();
      next.add(current.get(0));
      next.add(nums2[current.get(2) + 1]);
      next.add(current.get(2) + 1);
      queue.offer(next);
    }
    return result;
  }
}
// @lc code=end

