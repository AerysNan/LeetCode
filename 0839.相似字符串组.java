/*
 * @lc app=leetcode.cn id=839 lang=java
 *
 * [839] 相似字符串组
 */

// @lc code=start
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
  public int numSimilarGroups(String[] A) {
    int m = A.length, n = A[0].length();
    UFS set = new UFS(m);
    if (m < n * n) {
      for (int i = 0; i < m; i++)
        for (int j = i + 1; j < m; j++)
          if (similar(A[i], A[j]))
            set.union(i, j);
    } else {
      HashMap<String, ArrayList<Integer>> buckets = new HashMap<>();
      for (int i = 0; i < m; i++) {
        char[] array = A[i].toCharArray();
        for (int x = 0; x < array.length; x++)
          for (int y = x + 1; y < array.length; y++) {
            swap(array, x, y);
            StringBuilder stringBuilder = new StringBuilder();
            for (char c : array)
              stringBuilder.append(c);
            buckets.computeIfAbsent(stringBuilder.toString(), s -> new ArrayList<Integer>()).add(i);
            swap(array, x, y);
          }
      }
      for (int i = 0; i < A.length; i++)
        if (buckets.containsKey(A[i]))
          for (int j : buckets.get(A[i]))
            set.union(i, j);
    }
    int result = 0;
    for (int i = 0; i < m; i++)
      if (set.parent[i] == i)
        result++;
    return result;
  }

  public boolean similar(String word1, String word2) {
    int diff = 0;
    for (int i = 0; i < word1.length(); i++)
      if (word1.charAt(i) != word2.charAt(i))
        diff++;
    return diff <= 2;
  }

  public void swap(char[] A, int i, int j) {
    char tmp = A[i];
    A[i] = A[j];
    A[j] = tmp;
  }
}

class UFS {
  int[] parent;

  public UFS(int N) {
    parent = new int[N];
    for (int i = 0; i < N; ++i)
      parent[i] = i;
  }

  public int find(int x) {
    if (parent[x] != x)
      parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    parent[find(x)] = find(y);
  }
}
// @lc code=end
