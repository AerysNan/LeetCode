/*
 * @lc app=leetcode.cn id=553 lang=java
 *
 * [553] 最优除法
 */

// @lc code=start
class Solution {
    public String optimalDivision(int[] nums) {
        if (nums.length == 1)
            return String.valueOf(nums[0]);
        if (nums.length == 2)
            return new StringBuilder().append(nums[0]).append("/").append(nums[1]).toString();
        StringBuilder result = new StringBuilder(nums[0] + "/(" + nums[1]);
        for (int i = 2; i < nums.length; i++)
            result.append("/" + nums[i]);
        result.append(")");
        return result.toString();
    }
}
// @lc code=end
