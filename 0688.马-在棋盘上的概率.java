/*
 * @lc app=leetcode.cn id=688 lang=java
 *
 * [688] “马”在棋盘上的概率
 */

// @lc code=start
class Solution {
    public double knightProbability(int N, int K, int sr, int sc) {
        double[][] dp = new double[N][N];
        int[][] dirs = new int[][] { { 2, 1 }, { 2, -1 }, { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { -2, 1 },
                { -2, -1 } };
        dp[sr][sc] = 1;
        for (; K > 0; K--) {
            double[][] buffer = new double[N][N];
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    for (int[] dir : dirs) {
                        int cr = r + dir[0];
                        int cc = c + dir[1];
                        if (0 <= cr && cr < N && 0 <= cc && cc < N)
                            buffer[cr][cc] += dp[r][c] / 8.0;
                    }
                }
            }
            dp = buffer;
        }
        double result = 0.0;
        for (double[] row : dp)
            for (double value : row)
                result += value;
        return result;
    }
}
// @lc code=end
