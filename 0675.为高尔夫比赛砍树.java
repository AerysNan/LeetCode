/*
 * @lc app=leetcode.cn id=675 lang=java
 *
 * [675] 为高尔夫比赛砍树
 */

// @lc code=start
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

class Solution {
    int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public int cutOffTree(List<List<Integer>> forest) {
        ArrayList<int[]> trees = new ArrayList<>();
        for (int x = 0; x < forest.size(); x++) {
            for (int y = 0; y < forest.get(0).size(); y++) {
                int value = forest.get(x).get(y);
                if (value > 1)
                    trees.add(new int[] { value, x, y });
            }
        }
        trees.sort((a, b) -> a[0] - b[0]);
        int result = 0, sourceX = 0, sourceY = 0;
        for (int[] tree : trees) {
            int distance = bfs(forest, sourceX, sourceY, tree[1], tree[2]);
            if (distance < 0)
                return -1;
            result += distance;
            sourceX = tree[1];
            sourceY = tree[2];
        }
        return result;
    }

    public int bfs(List<List<Integer>> forest, int sourceX, int sourceY, int targetX, int targetY) {
        int R = forest.size(), C = forest.get(0).size();
        LinkedList<int[]> queue = new LinkedList<>();
        queue.add(new int[] { sourceX, sourceY, 0 });
        boolean[][] visited = new boolean[R][C];
        visited[sourceX][sourceY] = true;
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == targetX && current[1] == targetY)
                return current[2];
            for (int[] dir : dirs) {
                int currentX = current[0] + dir[0], currentY = current[1] + dir[1];
                if (0 <= currentX && currentX < R && 0 <= currentY && currentY < C && !visited[currentX][currentY]
                        && forest.get(currentX).get(currentY) > 0) {
                    visited[currentX][currentY] = true;
                    queue.add(new int[] { currentX, currentY, current[2] + 1 });
                }
            }
        }
        return -1;
    }
}
// @lc code=end
