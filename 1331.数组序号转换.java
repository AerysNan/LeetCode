import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/*
 * @lc app=leetcode.cn id=1331 lang=java
 *
 * [1331] 数组序号转换
 */

// @lc code=start
class Solution {
  public int[] arrayRankTransform(int[] arr) {
    int n = arr.length;
    Integer[] index = IntStream.range(0, n).boxed().toArray(Integer[]::new);
    Arrays.sort(index, new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        return arr[i1] - arr[i2];
      }
    });
    int[] result = new int[arr.length];
    for (int i = 0, rank = 0; i < n; i++) {
      result[index[i]] = rank + 1;
      if (i != n - 1 && arr[index[i]] != arr[index[i + 1]])
        rank++;
    }
    return result;
  }
}

