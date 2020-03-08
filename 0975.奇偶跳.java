/*
 * @lc app=leetcode.cn id=975 lang=java
 *
 * [975] 奇偶跳
 */

// @lc code=start
import java.util.TreeMap;

class Solution {
  public int oddEvenJumps(int[] A) {
    int n = A.length;
    if (n <= 1)
      return n;
    boolean[] odd = new boolean[n], even = new boolean[n];
    odd[n - 1] = even[n - 1] = true;
    TreeMap<Integer, Integer> index = new TreeMap<>();
    index.put(A[n - 1], n - 1);
    for (int i = n - 2; i >= 0; i--) {
      int v = A[i];
      if (index.containsKey(v)) {
        odd[i] = even[index.get(v)];
        even[i] = odd[index.get(v)];
      } else {
        Integer lower = index.lowerKey(v);
        Integer higher = index.higherKey(v);
        if (lower != null)
          even[i] = odd[index.get(lower)];
        if (higher != null)
          odd[i] = even[index.get(higher)];
      }
      index.put(v, i);
    }
    int result = 0;
    for (boolean b : odd)
      if (b)
        result++;
    return result;
  }
}
// @lc code=end

