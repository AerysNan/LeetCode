/*
 * @lc app=leetcode.cn id=633 lang=java
 *
 * [633] 平方数之和
 */

// @lc code=start
class Solution {
    public boolean judgeSquareSum(int c) {
        int root = (int) Math.sqrt(c);
        for (int x = 0; x <= root; x++) {
            int y = (int) Math.sqrt(c - x * x);
            if (x * x + y * y == c)
                return true;
        }
        return false;
    }
}
// @lc code=end
