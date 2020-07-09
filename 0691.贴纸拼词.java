/*
 * @lc app=leetcode.cn id=691 lang=java
 *
 * [691] 贴纸拼词
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int minStickers(String[] stickers, String target) {
        int n = stickers.length, m = target.length();
        int[] dp = new int[1 << m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int[][] map = new int[n][26];
        for (int i = 0; i < n; i++)
            for (char c : stickers[i].toCharArray())
                map[i][c - 'a']++;
        dp[0] = 0;
        for (int i = 0; i < (1 << m); i++) {
            if (dp[i] == Integer.MAX_VALUE)
                continue;
            for (int j = 0; j < n; j++) {
                int[] count = Arrays.copyOf(map[j], 26);
                int state = i;
                for (int k = 0; k < m; k++) {
                    if ((state & (1 << k)) > 0)
                        continue;
                    if (count[target.charAt(k) - 'a'] > 0) {
                        state |= (1 << k);
                        count[target.charAt(k) - 'a']--;
                    }
                }
                dp[state] = Math.min(dp[state], dp[i] + 1);
            }
        }
        return dp[(1 << m) - 1] == Integer.MAX_VALUE ? -1 : dp[(1 << m) - 1];
    }
}
// @lc code=end
