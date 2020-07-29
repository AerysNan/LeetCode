/*
 * @lc app=leetcode.cn id=730 lang=java
 *
 * [730] 统计不同回文子序列
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    int[][] memo, prev, next;
    byte[] array;
    int M = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String S) {
        int N = S.length();
        prev = new int[N][4];
        next = new int[N][4];
        memo = new int[N][N];
        for (int[] row : prev)
            Arrays.fill(row, -1);
        for (int[] row : next)
            Arrays.fill(row, -1);
        array = new byte[N];
        int index = 0;
        for (char c : S.toCharArray())
            array[index++] = (byte) (c - 'a');
        int[] last = new int[4];
        Arrays.fill(last, -1);
        for (int i = 0; i < N; ++i) {
            last[array[i]] = i;
            for (int k = 0; k < 4; ++k)
                prev[i][k] = last[k];
        }
        Arrays.fill(last, -1);
        for (int i = N - 1; i >= 0; --i) {
            last[array[i]] = i;
            for (int k = 0; k < 4; ++k)
                next[i][k] = last[k];
        }

        return dp(0, N - 1) - 1;
    }

    public int dp(int i, int j) {
        if (memo[i][j] > 0)
            return memo[i][j];
        int result = 1;
        if (i <= j) {
            for (int k = 0; k < 4; ++k) {
                int i0 = next[i][k];
                int j0 = prev[j][k];
                if (i <= i0 && i0 <= j)
                    result++;
                if (-1 < i0 && i0 < j0)
                    result += dp(i0 + 1, j0 - 1);
                if (result >= M)
                    result -= M;
            }
        }
        memo[i][j] = result;
        return result;
    }
}
// @lc code=end
