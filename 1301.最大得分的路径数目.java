/*
 * @lc app=leetcode.cn id=1301 lang=java
 *
 * [1301] 最大得分的路径数目
 */

// @lc code=start
import java.util.List;

class Pair {
    int value, count;

    public Pair(int value, int count) {
        this.value = value;
        this.count = count;
    }
}

class Solution {
    int mod = (int) 1e9 + 7;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dp[i][j] = new Pair(-1, 0);
        dp[n - 1][n - 1].value = 0;
        dp[n - 1][n - 1].count = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - 1 && j == n - 1 || board.get(i).charAt(j) == 'X')
                    continue;
                update(dp, i, j, i + 1, j);
                update(dp, i, j, i, j + 1);
                update(dp, i, j, i + 1, j + 1);
                if (dp[i][j].value != -1) {
                    dp[i][j].value += (board.get(i).charAt(j) == 'E' ? 0 : board.get(i).charAt(j) - '0');
                }
            }
        }
        return dp[0][0].value == -1 ? new int[] { 0, 0 } : new int[] { dp[0][0].value, dp[0][0].count };
    }

    void update(Pair[][] dp, int x, int y, int u, int v) {
        int n = dp.length;
        if (u >= n || v >= n || dp[u][v].value == -1)
            return;
        if (dp[u][v].value > dp[x][y].value) {
            dp[x][y].value = dp[u][v].value;
            dp[x][y].count = dp[u][v].count;
        } else if (dp[u][v].value == dp[x][y].value)
            dp[x][y].count = (dp[x][y].count + dp[u][v].count) % mod;
    }
}
// @lc code=end
