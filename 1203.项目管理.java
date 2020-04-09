import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1203 lang=java
 *
 * [1203] 项目管理
 */

// @lc code=start
class Solution {
  boolean topSort(ArrayList<ArrayList<Integer>> adj, int i, ArrayList<Integer> result,
      int[] state) {
    if (state[i] != 0)
      return state[i] == 2;
    state[i] = 1;
    for (int n : adj.get(i))
      if (!topSort(adj, n, result, state))
        return false;
    state[i] = 2;
    result.add(i);
    return true;
  }

  public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
    ArrayList<Integer> list = new ArrayList<>();
    int[] state = new int[n + 2 * m];
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < n + 2 * m; i++)
      adj.add(new ArrayList<>());
    for (int i = 0; i < n; i++) {
      if (group[i] != -1) {
        adj.get(n + group[i]).add(i);
        adj.get(i).add(n + m + group[i]);
      }
      for (int j : beforeItems.get(i)) {
        if (group[i] != -1 && group[i] == group[j])
          adj.get(j).add(i);
        else {
          int ig = group[i] == -1 ? i : n + group[i];
          int jg = group[j] == -1 ? j : n + m + group[j];
          adj.get(jg).add(ig);
        }
      }
    }
    ArrayList<Integer> temp = new ArrayList<>();
    for (int i = adj.size() - 1; i >= 0; i--)
      if (!topSort(adj, i, temp, state))
        return new int[] {};
    ArrayList<Integer> result = new ArrayList<>();
    for (int i = temp.size() - 1; i >= 0; i--) {
      int value = temp.get(i);
      if (value < n)
        result.add(value);
    }
    return result.stream().mapToInt(i -> i).toArray();
  }
}
// @lc code=end

