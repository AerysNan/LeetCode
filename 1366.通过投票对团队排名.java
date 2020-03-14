/*
 * @lc app=leetcode.cn id=1366 lang=java
 *
 * [1366] 通过投票对团队排名
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
  public String rankTeams(String[] votes) {
    int n = votes[0].length();
    HashMap<Character, int[]> map = new HashMap<>();
    for (String vote : votes) {
      char[] array = vote.toCharArray();
      for (int i = 0; i < array.length; i++) {
        if (!map.containsKey(array[i]))
          map.put(array[i], new int[n]);
        map.get(array[i])[i]++;
      }
    }
    ArrayList<Pair<Character, int[]>> result = new ArrayList<>();
    for (Map.Entry<Character, int[]> e : map.entrySet())
      result.add(new Pair<>(e.getKey(), e.getValue()));
    result.sort(new Comparator<Pair<Character, int[]>>() {
      @Override
      public int compare(Pair<Character, int[]> p1, Pair<Character, int[]> p2) {
        int[] l1 = p1.getValue(), l2 = p2.getValue();
        int n = l1.length;
        for (int i = 0; i < n; i++) {
          int c = Integer.compare(l2[i], l1[i]);
          if (c != 0)
            return c;
        }
        return Character.compare(p1.getKey(), p2.getKey());
      }
    });
    StringBuilder stringBuilder = new StringBuilder();
    for (Pair<Character, int[]> p : result)
      stringBuilder.append(p.getKey());
    return stringBuilder.toString();
  }
}
// @lc code=end

