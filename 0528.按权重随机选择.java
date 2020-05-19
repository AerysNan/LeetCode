/*
 * @lc app=leetcode.cn id=528 lang=java
 *
 * [528] 按权重随机选择
 */

// @lc code=start
import java.util.Random;

class Solution {
    int[] acc;
    Random random;

    public Solution(int[] w) {
        int n = w.length;
        acc = new int[n];
        acc[0] = w[0];
        for (int i = 1; i < n; i++)
            acc[i] = acc[i - 1] + w[i];
        random = new Random();
    }

    public int pickIndex() {
        int x = random.nextInt(acc[acc.length - 1]), result = 0;
        while (acc[result] <= x)
            result++;
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(w); int param_1 = obj.pickIndex();
 */
// @lc code=end
