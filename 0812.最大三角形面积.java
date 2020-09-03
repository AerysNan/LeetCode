/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 */

// @lc code=start
class Solution {
  public double largestTriangleArea(int[][] points) {
    int n = points.length;
    double result = 0;
    for (int i = 0; i < n - 2; i++)
      for (int j = i + 1; j < n - 1; j++)
        for (int k = j + 1; k < n; k++)
          result = Math.max(result, area(points[i], points[j], points[k]));
    return result;
  }

  public double area(int[] P, int[] Q, int[] R) {
    return 0.5 * Math.abs(P[0] * Q[1] + Q[0] * R[1] + R[0] * P[1] - P[1] * Q[0] - Q[1] * R[0] - R[1] * P[0]);
  }
}
// @lc code=end
