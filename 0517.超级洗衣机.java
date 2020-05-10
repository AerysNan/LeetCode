/*
 * @lc app=leetcode.cn id=517 lang=java
 *
 * [517] 超级洗衣机
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length, total = Arrays.stream(machines).sum();
        if (total % n != 0)
            return -1;
        int average = total / n;
        for (int i = 0; i < n; i++)
            machines[i] -= average;
        int current = 0, max = 0, temp = 0, result = 0;
        for (int m : machines) {
            current += m;
            max = Math.max(max, Math.abs(current));
            temp = Math.max(max, m);
            result = Math.max(result, temp);
        }
        return result;
    }
}
// @lc code=end
