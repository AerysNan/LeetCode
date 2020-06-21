import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=646 lang=java
 *
 * [646] 最长数对链
 */

// @lc code=start
class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (x, y) -> x[1] - y[1]);
        int time = Integer.MIN_VALUE, result = 0;
        for (int[] pair : pairs) {
            if (pair[0] <= time)
                continue;
            result++;
            time = pair[1];
        }
        return result;
    }
}
// @lc code=end
