/*
 * @lc app=leetcode.cn id=598 lang=java
 *
 * [598] 范围求和 II
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        return ops.length == 0 ? m * n
                : Arrays.stream(ops).mapToInt(x -> x[0]).min().getAsInt()
                        * Arrays.stream(ops).mapToInt(x -> x[1]).min().getAsInt();
    }
}
// @lc code=end
