/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 0)
                continue;
            if (!dfs(i, 1, graph, color))
                return false;
        }
        return true;
    }

    boolean dfs(int index, int c, int[][] graph, int[] color) {
        color[index] = c;
        for (int v : graph[index]) {
            if (color[v] == c)
                return false;
            if (color[v] == 0 && !dfs(v, -c, graph, color))
                return false;
        }
        return true;
    }
}
// @lc code=end
