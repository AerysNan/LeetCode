/*
 * @lc app=leetcode.cn id=1356 lang=java
 *
 * [1356] 根据数字二进制下 1 的数目排序
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;

class Solution {
  public int[] sortByBits(int[] arr) {
    Integer[] array = Arrays.stream(arr).boxed().toArray(Integer[]::new);
    Arrays.sort(array, new Comparator<Integer>() {
      @Override
      public int compare(Integer i1, Integer i2) {
        int value = Integer.compare(Integer.bitCount(i1), Integer.bitCount(i2));
        return value == 0 ? Integer.compare(i1, i2) : value;
      }
    });
    return Arrays.stream(array).mapToInt(Integer::intValue).toArray();
  }
}
// @lc code=end

