/*
 * @lc app=leetcode.cn id=697 lang=java
 *
 * [697] 数组的度
 */

// @lc code=start
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>(), begin = new HashMap<>(), end = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            begin.putIfAbsent(nums[i], i);
            end.put(nums[i], i);
        }
        int max = Integer.MIN_VALUE, result = Integer.MAX_VALUE;
        for (int key : count.keySet())
            max = Math.max(max, count.get(key));
        for (Map.Entry<Integer, Integer> e : count.entrySet())
            if (e.getValue() == max)
                result = Math.min(result, end.get(e.getKey()) - begin.get(e.getKey()) + 1);
        return result;
    }
}
// @lc code=end
