/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public double distance(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = { p1, p2, p3, p4 };
        Arrays.sort(p, (l1, l2) -> l2[0] == l1[0] ? l1[1] - l2[1] : l1[0] - l2[0]);
        return distance(p[0], p[1]) != 0 && distance(p[0], p[1]) == distance(p[1], p[3])
                && distance(p[1], p[3]) == distance(p[3], p[2]) && distance(p[3], p[2]) == distance(p[2], p[0])
                && distance(p[0], p[3]) == distance(p[1], p[2]);
    }
}
// @lc code=end
