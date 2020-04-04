/*
 * @lc app=leetcode.cn id=1184 lang=java
 *
 * [1184] 公交站间的距离
 */

// @lc code=start
import java.util.Arrays;

class Solution {
  public int distanceBetweenBusStops(int[] distance, int start, int destination) {
    int sum = Arrays.stream(distance).sum(), n = distance.length;
    int result = 0;
    for (int i = start; i != destination; i = (i + 1) % n)
      result += distance[i];
    return Math.min(result, sum - result);
  }
}
// @lc code=end

