/*
 * @lc app=leetcode.cn id=673 lang=java
 *
 * [673] 最长递增子序列的个数
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return n;
        int[] lengths = new int[n], counts = new int[n];
        Arrays.fill(counts, 1);
        for (int j = 0; j < n; ++j) {
            for (int i = 0; i < j; ++i)
                if (nums[i] < nums[j]) {
                    if (lengths[i] >= lengths[j]) {
                        lengths[j] = lengths[i] + 1;
                        counts[j] = counts[i];
                    } else if (lengths[i] + 1 == lengths[j])
                        counts[j] += counts[i];
                }
        }
        int longest = Arrays.stream(lengths).max().getAsInt(), result = 0;
        for (int i = 0; i < n; ++i)
            if (lengths[i] == longest)
                result += counts[i];
        return result;
    }
}
// @lc code=end
