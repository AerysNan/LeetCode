/*
 * @lc app=leetcode.cn id=1200 lang=java
 *
 * [1200] 最小绝对差
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
  public List<List<Integer>> minimumAbsDifference(int[] arr) {
    Arrays.sort(arr);
    ArrayList<List<Integer>> result = new ArrayList<>();
    int n = arr.length, min = Integer.MAX_VALUE;
    for (int i = 0; i < n - 1; i++)
      min = Math.min(min, arr[i + 1] - arr[i]);
    for (int i = 0; i < n - 1; i++) {
      if (arr[i + 1] - arr[i] != min)
        continue;
      ArrayList<Integer> list = new ArrayList<>();
      list.add(arr[i]);
      list.add(arr[i + 1]);
      result.add(list);
    }
    return result;
  }
}
// @lc code=end

