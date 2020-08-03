/*
 * @lc app=leetcode.cn id=740 lang=java
 *
 * [740] 删除与获得点数
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0)
            return 0;
        int n = Arrays.stream(nums).max().getAsInt();
        int[] count = new int[n + 1];
        for (int num : nums)
            count[num]++;
        int dp_keep = count[1], dp_skip = 0;
        for (int i = 2; i <= n; i++) {
            int temp = dp_skip + i * count[i];
            dp_skip = Math.max(dp_keep, dp_skip);
            dp_keep = temp;
        }
        return Math.max(dp_keep, dp_skip);
    }
}
// @lc code=end
