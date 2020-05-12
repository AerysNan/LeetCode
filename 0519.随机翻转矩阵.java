/*
 * @lc app=leetcode.cn id=519 lang=java
 *
 * [519] 随机翻转矩阵
 */

// @lc code=start
import java.util.Random;
import java.util.HashMap;

class Solution {

    HashMap<Integer, Integer> map = new HashMap<>();
    int row, col, size;
    Random random = new Random();

    public Solution(int n_rows, int n_cols) {
        row = n_rows;
        col = n_cols;
        size = row * col;
    }

    public int[] flip() {
        int x = random.nextInt(size--);
        int index = map.getOrDefault(x, x);
        map.put(x, map.getOrDefault(size, size));
        return new int[] { index / col, index % col };
    }

    public void reset() {
        map.clear();
        size = row * col;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(n_rows, n_cols); int[] param_1 = obj.flip(); obj.reset();
 */
// @lc code=end
