/*
 * @lc app=leetcode.cn id=554 lang=java
 *
 * [554] 砖墙
 */

// @lc code=start
import java.util.HashMap;
import java.util.List;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int acc = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                acc += row.get(i);
                map.put(acc, map.getOrDefault(acc, 0) + 1);
            }
        }
        int result = wall.size();
        for (int key : map.keySet())
            result = Math.min(result, wall.size() - map.get(key));
        return result;
    }
}
// @lc code=end
