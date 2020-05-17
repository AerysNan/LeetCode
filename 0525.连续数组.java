/*
 * @lc app=leetcode.cn id=525 lang=java
 *
 * [525] 连续数组
 */

// @lc code=start
import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int acc = 0, result = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            acc += nums[i] == 0 ? -1 : 1;
            if (map.containsKey(acc))
                result = Math.max(result, i - map.get(acc));
            else
                map.put(acc, i);
        }
        return result;
    }
}
// @lc code=end
