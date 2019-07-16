import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1036 lang=java
 *
 * [1036] 逃离大迷宫
 */
class Solution {
  int max;
  int N = 1000000;
  int[][] dir = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public boolean isEscapePossible(int[][] blocked, int[] s, int[] t) {
    max = blocked.length * (blocked.length - 1) / 2;
    int v1 = reachable(blocked, s, t);
    if (v1 == 1)
      return true;
    if (v1 == -1)
      return false;
    return reachable(blocked, t, s) >= 0;
  }

  int reachable(int[][] blocked, int[] s, int[] t) {
    LinkedList<int[]> list = new LinkedList<>();
    HashSet<Long> block = new HashSet<>();
    for (int[] b : blocked)
      block.add(((long) b[0] << 20) + (long) b[1]);
    int count = 1;
    list.addLast(new int[] { s[0], s[1] });
    block.add(((long) s[0] << 20) + (long) s[1]);
    while (!list.isEmpty()) {
      if (count > max)
        return 0;
      int[] p = list.pollFirst();
      count++;
      for (int i = 0; i < 4; i++) {
        int newR = p[0] + dir[i][0], newC = p[1] + dir[i][1];
        if (newR < 0 || newR >= N || newC < 0 || newC >= N || block.contains(((long) newR << 20) + (long) newC))
          continue;
        if (newR == t[0] && newC == t[1])
          return 1;
        list.addLast(new int[] { newR, newC });
        block.add(((long) newR << 20) + (long) newC);
      }
    }
    return -1;
  }
}
