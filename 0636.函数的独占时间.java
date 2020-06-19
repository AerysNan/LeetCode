/*
 * @lc app=leetcode.cn id=636 lang=java
 *
 * [636] 函数的独占时间
 */

// @lc code=start
import java.util.Stack;
import java.util.List;

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];
        Stack<int[]> s = new Stack<>();
        for (String log : logs) {
            String[] slices = log.split(":");
            if (slices[1].equals("start")) {
                int id = Integer.parseInt(slices[0]), time = Integer.parseInt(slices[2]);
                if (!s.isEmpty())
                    result[s.peek()[0]] += time - s.peek()[1];
                s.push(new int[] { id, time });
            } else {
                int time = Integer.parseInt(slices[2]);
                int[] c = s.pop();
                result[c[0]] += time - c[1] + 1;
                if (!s.isEmpty())
                    s.peek()[1] = time + 1;
            }
        }
        return result;
    }
}
// @lc code=end
