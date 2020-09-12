/*
 * @lc app=leetcode.cn id=969 lang=java
 *
 * [969] 煎饼排序
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
  public List<Integer> pancakeSort(int[] arr) {
    ArrayList<Integer> result = new ArrayList<>();
    int n = arr.length;
    Integer[] index = new Integer[n];
    for (int i = 0; i < n; i++)
      index[i] = i;
    Arrays.sort(index, (i, j) -> arr[j] - arr[i]);
    for (int i : index) {
      for (int k : result)
        if (i + 1 <= k)
          i = k - 1 - i;
      result.add(i + 1);
      result.add(n--);
    }
    return result;
  }
}
// @lc code=end
