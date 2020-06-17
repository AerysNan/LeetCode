/*
 * @lc app=leetcode.cn id=621 lang=java
 *
 * [621] 任务调度器
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char task : tasks)
            map[task - 'A']++;
        Arrays.sort(map);
        int max = map[25] - 1, idle = max * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--)
            idle -= Math.min(map[i], max);
        return idle > 0 ? idle + tasks.length : tasks.length;
    }
}
// @lc code=end
