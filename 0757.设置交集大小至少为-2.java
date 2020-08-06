/*
 * @lc app=leetcode.cn id=757 lang=java
 *
 * [757]  设置交集大小至少为2
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int[] todo = new int[intervals.length];
        Arrays.fill(todo, 2);
        int result = 0;
        for (int i = intervals.length - 1; i >= 0; i--) {
            int s = intervals[i][0];
            int m = todo[i];
            for (int p = s; p < s + m; p++) {
                for (int j = 0; j <= i; j++)
                    if (todo[j] > 0 && p <= intervals[j][1])
                        todo[j]--;
                result++;
            }
        }
        return result;
    }
}
// @lc code=end
