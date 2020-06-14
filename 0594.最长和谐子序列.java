/*
 * @lc app=leetcode.cn id=594 lang=java
 *
 * [594] 最长和谐子序列
 */

// @lc code=start
import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        for (int key : map.keySet())
            if (map.containsKey(key + 1))
                result = Math.max(result, map.get(key) + map.get(key + 1));
        return result;
    }
}
// @lc code=end
