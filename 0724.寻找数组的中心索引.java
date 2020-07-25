import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心索引
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        if (nums.length == 0)
            return -1;
        int r = Arrays.stream(nums).sum() - nums[0], l = 0;
        if (r == 0)
            return 0;
        for (int i = 1; i < nums.length; i++) {
            l += nums[i - 1];
            r -= nums[i];
            if (l == r)
                return i;
        }
        return -1;
    }
}
// @lc code=end
