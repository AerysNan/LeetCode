import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1042 lang=java
 *
 * [1042] 不邻接植花
 */
class Solution {
  public int[] gardenNoAdj(int N, int[][] paths) {
    int[] result = new int[N];
    ArrayList<ArrayList<Integer>> map = new ArrayList<>();
    for (int i = 0; i < N; i++)
      map.add(new ArrayList<Integer>());
    for (int[] path : paths) {
      map.get(path[0] - 1).add(path[1] - 1);
      map.get(path[1] - 1).add(path[0] - 1);
    }
    for (int i = 0; i < N; i++) {
      boolean[] used = new boolean[4];
      for (int v : map.get(i))
        if (result[v] != 0)
          used[result[v] - 1] = true;
      for (int j = 0; j < 4; j++) {
        if (!used[j]) {
          result[i] = j + 1;
          break;
        }
      }
    }
    return result;
  }
}
