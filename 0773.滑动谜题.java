/*
 * @lc app=leetcode.cn id=773 lang=java
 *
 * [773] 滑动谜题
 */

// @lc code=start
import java.util.PriorityQueue;
import java.util.HashMap;
import java.util.Arrays;

class Node {
  String S;
  int[][] B;
  int h, r, c, d;

  Node(int[][] B, int r, int c, int d) {
    this.B = B;
    this.S = Arrays.deepToString(B);
    this.h = 0;
    this.r = r;
    this.c = c;
    this.d = d;
    int R = B.length, C = B[0].length;
    for (int x = 0; x < R; x++)
      for (int y = 0; y < C; y++) {
        if (B[x][y] == 0)
          continue;
        int v = (B[x][y] + R * C - 1) % (R * C);
        h += Math.abs(x - v / C) + Math.abs(y - v % C);
      }
    h /= 2;
  }
}

class Solution {
  public int slidingPuzzle(int[][] B) {
    int R = B.length, C = B[0].length;
    int r = 0, c = 0;
    search: for (r = 0; r < R; r++)
      for (c = 0; c < C; c++)
        if (B[r][c] == 0)
          break search;

    int[][] dirs = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
    PriorityQueue<Node> heap = new PriorityQueue<Node>((a, b) -> (a.h + a.d) - (b.h + b.d));
    Node start = new Node(B, r, c, 0);
    heap.add(start);
    HashMap<String, Integer> cost = new HashMap<>();
    cost.put(start.S, Integer.MAX_VALUE);
    String target = Arrays.deepToString(new int[][] { { 1, 2, 3 }, { 4, 5, 0 } });
    String invalid = Arrays.deepToString(new int[][] { { 1, 2, 3 }, { 5, 4, 0 } });
    while (!heap.isEmpty()) {
      Node node = heap.poll();
      if (node.S.equals(target))
        return node.d;
      if (node.S.equals(invalid))
        return -1;
      if (node.d + node.h > cost.get(node.S))
        continue;
      for (int[] dir : dirs) {
        int newR = dir[0] + node.r;
        int newC = dir[1] + node.c;
        if (newR < 0 || newR >= R || newC < 0 || newC >= C)
          continue;
        int[][] newboard = new int[R][C];
        for (int i = 0; i < R; i++)
          newboard[i] = node.B[i].clone();
        newboard[node.r][node.c] = newboard[newR][newC];
        newboard[newR][newC] = 0;
        Node newNode = new Node(newboard, newR, newC, node.d + 1);
        if (newNode.d + newNode.h >= cost.getOrDefault(newNode.S, Integer.MAX_VALUE))
          continue;
        heap.add(newNode);
        cost.put(newNode.S, newNode.d + newNode.h);
      }
    }
    return -1;
  }
}
// @lc code=end
