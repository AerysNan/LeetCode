/*
 * @lc app=leetcode.cn id=645 lang=java
 *
 * [645] 错误的集合
 */

// @lc code=start
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2], map = new int[nums.length + 1];
        for (int num : nums) {
            if (map[num] > 0)
                result[0] = num;
            map[num] = num;
        }
        for (int i = 1; i <= nums.length; i++) {
            if (map[i] == 0) {
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
// @lc code=end
