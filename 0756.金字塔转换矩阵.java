/*
 * @lc app=leetcode.cn id=756 lang=java
 *
 * [756] 金字塔转换矩阵
 */

// @lc code=start
import java.util.List;
import java.util.HashSet;

class Solution {
    int[][] map;
    HashSet<Long> seen;

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        map = new int[7][7];
        for (String a : allowed)
            map[a.charAt(0) - 'A'][a.charAt(1) - 'A'] |= 1 << (a.charAt(2) - 'A');
        seen = new HashSet<>();
        int n = bottom.length();
        int[][] pyramid = new int[n][n];
        for (int i = 0; i < n; i++)
            pyramid[n - 1][i] = bottom.charAt(i) - 'A';
        return solve(pyramid, 0, n - 1, 0);
    }

    public boolean solve(int[][] pyramid, long current, int n, int index) {
        if (n == 1 && index == 1)
            return true;
        else if (index == n) {
            if (seen.contains(current))
                return false;
            seen.add(current);
            return solve(pyramid, 0, n - 1, 0);
        } else {
            int w = map[pyramid[n][index]][pyramid[n][index + 1]];
            for (int b = 0; b < 7; b++) {
                if (((w >> b) & 1) == 0)
                    continue;
                pyramid[n - 1][index] = b;
                if (solve(pyramid, current * 8 + (b + 1), n, index + 1))
                    return true;
            }
            return false;
        }
    }
}
// @lc code=end
