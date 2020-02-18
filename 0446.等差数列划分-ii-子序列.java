/*
 * @lc app=leetcode.cn id=446 lang=java
 *
 * [446] 等差数列划分 II - 子序列
 */

// @lc code=start
import java.util.HashMap;

class Solution {
  public int numberOfArithmeticSlices(int[] A) {
    int result = 0;
    HashMap<Integer, Integer>[] map = new HashMap[A.length];
    for (int i = 0; i < A.length; i++) {
      map[i] = new HashMap<>(i);
      for (int j = 0; j < i; j++) {
        long d = (long) A[i] - A[j];
        if (d <= Integer.MIN_VALUE || d > Integer.MAX_VALUE)
          continue;
        int c1 = map[i].getOrDefault((int) d, 0);
        int c2 = map[j].getOrDefault((int) d, 0);
        result += c2;
        map[i].put((int) d, c1 + c2 + 1);
      }
    }

    return result;
  }
}
// @lc code=end
