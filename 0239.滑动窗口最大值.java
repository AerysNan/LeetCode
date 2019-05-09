import java.util.Deque;

/*
 * @lc app=leetcode.cn id=239 lang=java
 *
 * [239] 滑动窗口最大值
 */
class Solution {
  private Deque<Integer> queue;

  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums.length == 0)
      return new int[0];
    int length = nums.length;
    int[] result = new int[length - k + 1];
    queue = new ArrayDeque<>();
    for (int i = 0; i < nums.length; i++) {
      while (!queue.isEmpty() && queue.peekFirst() < i - k + 1)
        queue.pollFirst();
      while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i])
        queue.pollLast();
      queue.offer(i);
      if (i >= k - 1)
        result[i - k + 1] = nums[queue.peekFirst()];
    }
    return result;
  }
}
