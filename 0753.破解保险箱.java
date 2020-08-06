/*
 * @lc app=leetcode.cn id=753 lang=java
 *
 * [753] 破解保险箱
 */

// @lc code=start
import java.util.HashSet;
import java.util.LinkedList;

class Solution {
    boolean[] visited;
    StringBuilder result;
    int mod;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1)
            return "0";
        mod = (int) Math.pow(10, n - 1);
        visited = new boolean[10000];
        result = new StringBuilder();
        int start = 0;
        dfs(start, k);
        for (int i = 0; i < n - 1; i++)
            result.append(0);
        return result.toString();
    }

    public void dfs(int current, int k) {
        for (int i = 0; i < k; i++) {
            int value = current * 10 + i;
            if (visited[value])
                continue;
            visited[value] = true;
            dfs(value % mod, k);
            result.append(i);
        }
    }
}
// @lc code=end
