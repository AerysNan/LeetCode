/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
import java.util.HashSet;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                char number = board[i][j];
                if (number == '.')
                    continue;
                if (!set.add(number + "r" + i) || !set.add(number + "c" + j)
                        || !set.add(number + "b" + i / 3 + "-" + j / 3))
                    return false;
            }
        }
        return true;
    }
}
// @lc code=end
