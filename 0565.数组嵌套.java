/*
 * @lc app=leetcode.cn id=565 lang=java
 *
 * [565] 数组嵌套
 */

// @lc code=start
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length, result = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == -1)
                continue;
            int current = nums[i], count = 0;
            while (nums[current] != -1) {
                int next = nums[current];
                nums[current] = -1;
                count++;
                current = next;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}
// @lc code=end
