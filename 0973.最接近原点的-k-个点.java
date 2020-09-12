import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] 最接近原点的 K 个点
 */

// @lc code=start
class Solution {
  public int[][] kClosest(int[][] points, int K) {
    sort(points, 0, points.length - 1, K);
    return Arrays.copyOfRange(points, 0, K);
  }

  void sort(int[][] points, int l, int r, int K) {
    if (l > r)
      return;
    int[] pivot = Arrays.copyOf(points[l], 2);
    int i = l, j = r, v = d(pivot);
    while (i < j) {
      while (i < j && d(points[j]) > v)
        j--;
      points[i][0] = points[j][0];
      points[i][1] = points[j][1];
      while (i < j && d(points[i]) <= v)
        i++;
      points[j][0] = points[i][0];
      points[j][1] = points[i][1];
    }
    points[i][0] = pivot[0];
    points[i][1] = pivot[1];
    if (i - l + 1 == K)
      return;
    if (i - l + 1 > K)
      sort(points, l, i - 1, K);
    else
      sort(points, i + 1, r, K - i + l - 1);
  }

  int d(int[] p) {
    return p[0] * p[0] + p[1] * p[1];
  }
}
// @lc code=end
