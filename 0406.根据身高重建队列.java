/*
 * @lc app=leetcode.cn id=406 lang=java
 *
 * [406] 根据身高重建队列
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Solution {
  public int[][] reconstructQueue(int[][] people) {
    Arrays.sort(people, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
      }
    });
    ArrayList<int[]> result = new ArrayList<>();
    for (int[] person : people)
      result.add(person[1], person);
    return result.toArray(new int[people.length][]);
  }
}
// @lc code=end

