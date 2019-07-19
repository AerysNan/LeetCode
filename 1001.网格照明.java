import java.util.HashMap;
import java.util.HashSet;
import javafx.util.Pair;

/*
 * @lc app=leetcode.cn id=1001 lang=java
 *
 * [1001] 网格照明
 */
class Solution {
  int[][] args = new int[][] { { 1, 0 }, { 0, 1 }, { 1, 1 }, { 1, -1 } };
  int[][] dirs = new int[][] { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 }, { 1, 1 }, { -1, -1 }, { 1, -1 },
      { -1, 1 } };

  public int[] gridIllumination(int N, int[][] lamps, int[][] queries) {
    HashMap<Integer, Integer>[] maps = (HashMap<Integer, Integer>[]) new HashMap[4];
    for (int i = 0; i < 4; i++)
      maps[i] = new HashMap<>();
    HashSet<Pair<Integer, Integer>> set = new HashSet<>();
    for (int[] lamp : lamps) {
      set.add(new Pair<>(lamp[0], lamp[1]));
      for (int i = 0; i < 4; i++) {
        int key = lamp[0] * args[i][0] + lamp[1] * args[i][1];
        maps[i].put(key, maps[i].getOrDefault(key, 0) + 1);
      }
    }
    int n = queries.length;
    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      boolean found = false;
      for (int j = 0; j < 4; j++) {
        int key = queries[i][0] * args[j][0] + queries[i][1] * args[j][1];
        if (maps[j].containsKey(key)) {
          found = true;
          break;
        }
      }
      result[i] = found ? 1 : 0;
      for (int j = 0; j < 9; j++) {
        int newRow = queries[i][0] + dirs[j][0], newCol = queries[i][1] + dirs[j][1];
        if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || !set.contains(new Pair<>(newRow, newCol)))
          continue;
        set.remove(new Pair<>(newRow, newCol));
        for (int k = 0; k < 4; k++) {
          int key = newRow * args[k][0] + newCol * args[k][1];
          int value = maps[k].get(key) - 1;
          if (value == 0)
            maps[k].remove(key);
          else
            maps[k].put(key, value);
        }
      }
    }
    return result;
  }
}
