import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=821 lang=java
 *
 * [821] 字符的最短距离
 */

// @lc code=start
class Solution {
  public int[] shortestToChar(String S, char C) {
    int n = S.length();
    int[] result = new int[n];
    char[] array = S.toCharArray();
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++)
      if (array[i] == C)
        list.add(i);
    int index = -1;
    for (int i = 0; i < n; i++) {
      int distance = Integer.MAX_VALUE;
      if (array[i] == C)
        index++;
      if (index >= 0)
        distance = Math.min(distance, Math.abs(i - list.get(index)));
      if (index < list.size() - 1)
        distance = Math.min(distance, Math.abs(i - list.get(index + 1)));
      result[i] = distance;
    }
    return result;
  }
}
// @lc code=end
