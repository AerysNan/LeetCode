/*
 * @lc app=leetcode.cn id=739 lang=java
 *
 * [739] 每日温度
 */

// @lc code=start
import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> s = new Stack<>();
        int n = T.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && T[s.peek()] < T[i])
                result[s.peek()] = i - s.pop();
            s.push(i);
        }
        return result;
    }
}
// @lc code=end
