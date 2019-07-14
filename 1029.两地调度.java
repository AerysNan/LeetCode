import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1029 lang=java
 *
 * [1029] 两地调度
 */
class Solution {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] i1, int[] i2) {
        int val1 = Math.abs(i1[0] - i1[1]);
        int val2 = Math.abs(i2[0] - i2[1]);
        return val2 - val1;
      }
    });
    int result = 0, remainA = costs.length / 2, remainB = costs.length / 2;
    int index = 0;
    while (remainA > 0 && remainB > 0 && index < costs.length) {
      if (costs[index][0] >= costs[index][1]) {
        result += costs[index++][1];
        remainB--;
      } else {
        result += costs[index++][0];
        remainA--;
      }
    }
    if (remainA > 0)
      for (int i = index; i < costs.length; i++)
        result += costs[i][0];
    if (remainB > 0)
      for (int i = index; i < costs.length; i++)
        result += costs[i][1];
    return result;
  }
}
