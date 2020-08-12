/*
 * @lc app=leetcode.cn id=769 lang=java
 *
 * [769] 最多能完成排序的块
 */

// @lc code=start
class Solution {
  public int maxChunksToSorted(int[] arr) {
    int result = 0, max = 0, n = arr.length;
    for (int i = 0; i < n; i++) {
      max = Math.max(max, arr[i]);
      if (max == i)
        result++;
    }
    return result;
  }
}
// @lc code=end
