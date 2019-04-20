/*
 * @lc app=leetcode.cn id=546 lang=java
 *
 * [546] 移除盒子
 *
 * https://leetcode-cn.com/problems/remove-boxes/description/
 *
 * algorithms
 * Hard (42.96%)
 * Total Accepted:    238
 * Total Submissions: 552
 * Testcase Example:  '[1,3,2,2,2,3,4,3,1]'
 *
 * 给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。
 * 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k*k
 * 个积分。
 * 当你将所有盒子都去掉之后，求你能获得的最大积分和。
 *
 * 示例 1：
 * 输入:
 *
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 *
 *
 * 输出:
 *
 *
 * 23
 *
 *
 * 解释:
 *
 *
 * [1, 3, 2, 2, 2, 3, 4, 3, 1]
 * ----> [1, 3, 3, 4, 3, 1] (3*3=9 分)
 * ----> [1, 3, 3, 3, 1] (1*1=1 分)
 * ----> [1, 1] (3*3=9 分)
 * ----> [] (2*2=4 分)
 *
 *
 *
 *
 * 提示：盒子的总数 n 不会超过 100。
 *
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
