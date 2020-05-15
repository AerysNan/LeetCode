/*
 * @lc app=leetcode.cn id=523 lang=java
 *
 * [523] 连续的子数组和
 */

// @lc code=start
import java.util.HashMap;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0) {
            for (int i = 0; i < nums.length - 1; i++)
                if (nums[i] == 0 && nums[i + 1] == 0)
                    return true;
            return false;
        }
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = (sum + nums[i]) % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}
// @lc code=end
