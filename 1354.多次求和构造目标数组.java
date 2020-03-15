/*
 * @lc app=leetcode.cn id=1354 lang=java
 *
 * [1354] 多次求和构造目标数组
 */

// @lc code=start
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public boolean isPossible(int[] target) {
    if (target.length == 1)
      return target[0] == 1;
    PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return i2 - i1;
      }
    });
    long sum = 0;
    for (int x : target) {
      queue.add(x);
      sum += x;
    }
    while (!queue.isEmpty()) {
      long x = queue.poll();
      if (x == 1)
        return true;
      if (x * 2 - sum < 1)
        return false;
      long left = sum - x;
      long y = queue.peek();
      long k;
      if (y == 1)
        k = (x - y + left - 1) / left;
      else
        k = (x - y) / left + 1;
      x -= k * left;
      if (x <= 0)
        return false;
      sum -= k * left;
      queue.add((int) x);
    }
    return true;
  }
}
// @lc code=end

