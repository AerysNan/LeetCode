/*
 * @lc app=leetcode.cn id=576 lang=java
 *
 * [576] 出界的路径数
 */

// @lc code=start
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int V = (int) 1e9 + 7;
        int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        int[][][] dp = new int[m][n][N + 1];
        for (int z = 1; z <= N; z++) {
            for (int x = 0; x < m; x++) {
                dp[x][0][z]++;
                dp[x][n - 1][z]++;
            }
            for (int y = 0; y < n; y++) {
                dp[0][y][z]++;
                dp[m - 1][y][z]++;
            }
        }
        for (int z = 2; z <= N; z++) {
            for (int x = 0; x < m; x++) {
                for (int y = 0; y < n; y++) {
                    for (int[] dir : dirs) {
                        int newX = x + dir[0], newY = y + dir[1];
                        if (newX < 0 || newX >= m || newY < 0 || newY >= n)
                            continue;
                        dp[x][y][z] = (dp[x][y][z] + dp[newX][newY][z - 1]) % V;
                    }
                }
            }
        }
        return dp[i][j][N];
    }
}
// @lc code=end
