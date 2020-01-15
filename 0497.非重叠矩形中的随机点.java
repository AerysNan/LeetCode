/*
 * @lc app=leetcode.cn id=497 lang=java
 *
 * [497] 非重叠矩形中的随机点
 */

// @lc code=start
import java.util.Random;
import java.util.TreeMap;

class Solution {
  int[][] rects;
  TreeMap<Integer, Integer> map;
  int total;
  Random random;

  public Solution(int[][] rects) {
    this.rects = rects;
    this.map = new TreeMap<>();
    this.random = new Random();
    for (int i = 0; i < rects.length; i++) {
      int area = (rects[i][2] - rects[i][0] + 1) * (rects[i][3] - rects[i][1] + 1);
      this.total += area;
      this.map.put(this.total, i);
    }
  }

  public int[] pick() {
    int acc = random.nextInt(this.total);
    int[] rect = this.rects[map.higherEntry(acc).getValue()];
    return new int[] {random.nextInt(rect[2] - rect[0] + 1) + rect[0],
        random.nextInt(rect[3] - rect[1] + 1) + rect[1]};
  }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
// @lc code=end

