/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        int n = nums.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        Arrays.sort(pairs, (x, y) -> y[0] - x[0]);
        String[] result = new String[n];
        if (n >= 1)
            result[pairs[0][1]] = "Gold Medal";
        if (n >= 2)
            result[pairs[1][1]] = "Silver Medal";
        if (n >= 3)
            result[pairs[2][1]] = "Bronze Medal";
        for (int i = 3; i < n; i++)
            result[pairs[i][1]] = String.valueOf(i + 1);
        return result;
    }
}
// @lc code=end
