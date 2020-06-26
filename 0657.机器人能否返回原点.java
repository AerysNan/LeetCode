/*
 * @lc app=leetcode.cn id=657 lang=java
 *
 * [657] 机器人能否返回原点
 */

// @lc code=start
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move : moves.toCharArray()) {
            if (move == 'U')
                y++;
            else if (move == 'D')
                y--;
            else if (move == 'R')
                x++;
            else
                x--;
        }
        return x == 0 && y == 0;
    }
}
// @lc code=end
