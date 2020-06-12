/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for (int candy : candies)
            set.add(candy);
        return Math.min(candies.length / 2, set.size());
    }
}
// @lc code=end
