import java.util.ArrayList;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1079 lang=java
 *
 * [1079] 活字印刷
 */
class Solution {
  int dfs(ArrayList<Integer> list) {
    int result = 1;
    for (int i = 0; i < 26; i++) {
      if (list.get(i) == 0)
        continue;
      list.set(i, list.get(i) - 1);
      result += dfs(list);
      list.set(i, list.get(i) + 1);
    }
    return result;
  }

  public int numTilePossibilities(String tiles) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < 26; i++)
      list.add(0);
    for (int i = 0; i < tiles.length(); i++) {
      int pos = tiles.charAt(i) - 'A';
      list.set(pos, list.get(pos) + 1);
    }
    return dfs(list) - 1;
  }
}
