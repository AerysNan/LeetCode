/*
 * @lc app=leetcode.cn id=5350 lang=java
 *
 * [5350] 将整数按权重排序
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Comparator;

class Solution {
  Integer[] w = new Integer[1001];

  public int getKth(int lo, int hi, int k) {
    ArrayList<Integer> list = new ArrayList<>();
    for (int i = lo; i <= hi; i++)
      list.add(i);
    list.sort(new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return compute(i1) == compute(i2) ? i1 - i2 : compute(i1) - compute(i2);
      }
    });
    return list.get(k - 1);
  }

  int compute(int v) {
    if (w[v] != null)
      return w[v];
    int result = 0;
    while (v != 1) {
      if (v % 2 == 0)
        v /= 2;
      else
        v = v * 3 + 1;
      result++;
    }
    w[v] = result;
    return result;
  }
}
// @lc code=end

