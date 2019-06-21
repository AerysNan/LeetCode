import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1051 lang=java
 *
 * [1051] 高度检查器
 */
class Solution {
  public int heightChecker(int[] heights) {
    int n = heights.length;
    int[] sorted = new int[n];
    System.arraycopy(heights, 0, sorted, 0, n);
    Arrays.sort(sorted);
    int result = 0;
    for (int i = 0; i < n; i++)
      if (heights[i] != sorted[i])
        result++;
    return result;
  }
}
