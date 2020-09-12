/*
 * @lc app=leetcode.cn id=992 lang=java
 *
 * [992] K 个不同整数的子数组
 */

// @lc code=start
import java.util.HashMap;

class Window {
  HashMap<Integer, Integer> map;
  int count;

  public Window() {
    map = new HashMap<>();
    count = 0;
  }

  void add(int key) {
    int value = map.getOrDefault(key, 0);
    if (value == 0)
      count++;
    map.put(key, value + 1);
  }

  void sub(int key) {
    int value = map.getOrDefault(key, 0);
    if (value == 1)
      count--;
    map.put(key, value - 1);
  }
}

class Solution {
  public int subarraysWithKDistinct(int[] A, int K) {
    Window w1 = new Window(), w2 = new Window();
    int result = 0, l = 0, r = 0;
    for (int end = 0; end < A.length; end++) {
      w1.add(A[end]);
      w2.add(A[end]);
      while (w1.count > K)
        w1.sub(A[l++]);
      while (w2.count >= K)
        w2.sub(A[r++]);
      result += r - l;
    }
    return result;
  }
}
// @lc code=end
