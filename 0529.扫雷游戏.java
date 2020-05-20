/*
 * @lc app=leetcode.cn id=529 lang=java
 *
 * [529] 扫雷游戏
 */

// @lc code=start
class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public char[][] updateBoard(char[][] board, int[] click) {
        execute(board, click[0], click[1]);
        return board;
    }

    void execute(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        char c = board[x][y];
        if (c == 'M')
            board[x][y] = 'X';
        else if (c == 'E') {
            int count = getCount(board, x, y);
            if (count == 0) {
                board[x][y] = 'B';
                for (int[] dir : dirs)
                    execute(board, x + dir[0], y + dir[1]);
            } else
                board[x][y] = (char) (count + '0');
        }

    }

    int getCount(char[][] board, int x, int y) {
        int result = 0;
        for (int[] dir : dirs) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[0].length || board[newX][newY] != 'M')
                continue;
            result++;
        }
        return result;
    }
}
// @lc code=end
