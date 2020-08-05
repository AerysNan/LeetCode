/*
 * @lc app=leetcode.cn id=749 lang=java
 *
 * [749] 隔离病毒
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashSet;

class Solution {
    HashSet<Integer> seen;
    ArrayList<HashSet<Integer>> regions;
    ArrayList<HashSet<Integer>> frontiers;
    ArrayList<Integer> perimeters;
    int[][] grid;
    int R, C;
    int[][] dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public int containVirus(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;
        int result = 0;
        while (true) {
            seen = new HashSet<>();
            regions = new ArrayList<>();
            frontiers = new ArrayList<>();
            perimeters = new ArrayList<>();
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (grid[r][c] == 1 && !seen.contains(r * C + c)) {
                        regions.add(new HashSet<>());
                        frontiers.add(new HashSet<>());
                        perimeters.add(0);
                        dfs(r, c);
                    }
                }
            }
            if (regions.isEmpty())
                break;
            int triageIndex = 0;
            for (int i = 0; i < frontiers.size(); i++)
                if (frontiers.get(triageIndex).size() < frontiers.get(i).size())
                    triageIndex = i;
            result += perimeters.get(triageIndex);
            for (int i = 0; i < regions.size(); i++) {
                if (i == triageIndex)
                    for (int code : regions.get(i))
                        grid[code / C][code % C] = -1;
                else {
                    for (int code : regions.get(i)) {
                        int x = code / C, y = code % C;
                        for (int[] dir : dirs) {
                            int newX = x + dir[0], newY = y + dir[1];
                            if (newX >= 0 && newX < R && newY >= 0 && newY < C && grid[newX][newY] == 0)
                                grid[newX][newY] = 1;
                        }
                    }
                }
            }
        }
        return result;
    }

    public void dfs(int x, int y) {
        if (seen.contains(x * C + y))
            return;
        seen.add(x * C + y);
        int N = regions.size();
        regions.get(N - 1).add(x * C + y);
        for (int[] dir : dirs) {
            int newX = x + dir[0], newY = y + dir[1];
            if (newX < 0 || newX >= R || newY < 0 || newY >= C)
                continue;
            if (grid[newX][newY] == 1)
                dfs(newX, newY);
            else if (grid[newX][newY] == 0) {
                frontiers.get(N - 1).add(newX * C + newY);
                perimeters.set(N - 1, perimeters.get(N - 1) + 1);
            }
        }
    }
}
// @lc code=end
