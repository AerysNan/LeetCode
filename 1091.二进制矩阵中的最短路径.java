import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1091 lang=java
 *
 * [1091] 二进制矩阵中的最短路径
 */
class Solution {
  public static int[][] move = new int[][] { { 0, -1 }, { 1, -1 }, { 1, 0 }, { 1, 1 }, { 0, 1 }, { -1, 1 }, { -1, 0 },
      { -1, -1 } };

  class Position {
    int X;
    int Y;

    Position(int X, int Y) {
      this.X = X;
      this.Y = Y;
    }
  }

  public int shortestPathBinaryMatrix(int[][] grid) {
    int N = grid.length;
    if (grid[0][0] == 1 || grid[N - 1][N - 1] == 1)
      return -1;
    int[][] dist = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        dist[i][j] = -1;
    LinkedList<Position> list = new LinkedList<>();
    list.add(new Position(0, 0));
    dist[0][0] = 1;
    while (!list.isEmpty()) {
      Position p = list.pollFirst();
      for (int i = 0; i < 8; i++) {
        int newX = p.X + move[i][0];
        int newY = p.Y + move[i][1];
        if (newX < 0 || newX >= N || newY < 0 || newY >= N || grid[newX][newY] == 1)
          continue;
        dist[newX][newY] = dist[p.X][p.Y] + 1;
        grid[newX][newY] = 1;
        list.addLast(new Position(newX, newY));
      }
    }
    return dist[N - 1][N - 1];
  }
}
