/*
 * @lc app=leetcode.cn id=661 lang=java
 *
 * [661] 图片平滑器
 */

// @lc code=start
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int m = M.length, n = M[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                int count = 0;
                for (int nr = i - 1; nr <= i + 1; ++nr)
                    for (int nc = j - 1; nc <= j + 1; ++nc) {
                        if (0 <= nr && nr < m && 0 <= nc && nc < n) {
                            result[i][j] += M[nr][nc];
                            count++;
                        }
                    }
                result[i][j] /= count;
            }
        return result;
    }
}
// @lc code=end
