import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1105 lang=java
 *
 * [1105] 填充书架
 */
class Solution {
  public int minHeightShelves(int[][] books, int shelf_width) {
    int size = books.length;
    int[] dp = new int[size];
    dp[0] = books[0][1];
    for (int i = 1; i < size; i++) {
      dp[i] = Integer.MAX_VALUE;
      int maxHeight = Integer.MIN_VALUE, accWidth = 0;
      for (int j = i; j >= 0 && accWidth + books[j][0] <= shelf_width; j--) {
        maxHeight = Math.max(maxHeight, books[j][1]);
        dp[i] = Math.min(dp[i], (j == 0 ? 0 : dp[j - 1]) + maxHeight);
        accWidth += books[j][0];
      }
    }
    return dp[size - 1];
  }
}
