import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1349 lang=java
 *
 * [1349] 参加考试的最大学生数
 */

// @lc code=start
class Solution {
  public int maxStudents(char[][] seats) {
    System.out.println((3 & 1 << 0) > 0 && (3 & 1 << 1) > 0);
    int m = seats.length, n = seats[0].length, state = 1 << n;
    int[][] dp = new int[m + 1][state];
    for (int i = 1; i <= m; i++) {
      for (int j = 0; j < state; j++) {
        boolean valid = true;
        for (int k = 0; k < n; k++) {
          if ((j & 1 << k) > 0 && seats[i - 1][k] == '#'
              || k < n - 1 && (j & 1 << k) > 0 && (j & 1 << (k + 1)) > 0) {
            valid = false;
            break;
          }
        }
        if (!valid) {
          dp[i][j] = -1;
          continue;
        }
        for (int k = 0; k < state; k++) {
          if (dp[i - 1][k] == -1)
            continue;
          valid = true;
          for (int l = 0; l < n; l++) {
            if ((k & 1 << l) > 0
                && ((l > 0 && (j & 1 << (l - 1)) > 0) || (l < n - 1 && (j & 1 << (l + 1)) > 0))) {
              valid = false;
              break;
            }
          }
          if (valid)
            dp[i][j] = Math.max(dp[i][j], dp[i - 1][k] + Integer.bitCount(j));
        }
      }
    }
    return Arrays.stream(dp[m]).reduce(0, (x, y) -> Math.max(x, y));
  }
}
// @lc code=end
