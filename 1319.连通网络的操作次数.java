/*
 * @lc app=leetcode.cn id=1319 lang=java
 *
 * [1319] 连通网络的操作次数
 */

// @lc code=start
import java.util.stream.IntStream;

class Solution {
  int[] source;

  int find(int x) {
    while (source[x] != x)
      x = source[x];
    return x;
  }

  public int makeConnected(int n, int[][] connections) {
    source = IntStream.range(0, n).toArray();
    int duplicate = 0;
    for (int[] connection : connections) {
      int source1 = find(connection[0]), source2 = find(connection[1]);
      if (source1 == source2)
        duplicate++;
      else
        source[source1] = source2;
    }
    int size = 0;
    for (int i = 0; i < n; i++)
      if (source[i] == i)
        size++;
    return duplicate < size - 1 ? -1 : size - 1;
  }
}


// @lc code=end

