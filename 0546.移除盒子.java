/*
 * @lc app=leetcode.cn id=546 lang=java
 *
 * [546] 移除盒子
 */
class Solution {
  private int[][][] record;

  public int removeBoxes(int[] boxes) {
    int n = boxes.length;
    record = new int[n][n][n];
    return dp(boxes, 0, n - 1, 0);
  }

  private int dp(int[] boxes, int l, int h, int k) {
    if (l > h)
      return 0;
    if (record[l][h][k] > 0)
      return record[l][h][k];
    if (l < h && boxes[l] == boxes[l + 1]) {
      int value = dp(boxes, l + 1, h, k + 1);
      record[l][h][k] = value;
      return value;
    }
    int result = (k + 1) * (k + 1) + dp(boxes, l + 1, h, 0);
    for (int i = l + 1; i <= h; i++) {
      if (boxes[l] != boxes[i])
        continue;
      result = Math.max(result, dp(boxes, l + 1, i - 1, 0) + dp(boxes, i, h, k + 1));
    }
    record[l][h][k] = result;
    return result;
  }
}
