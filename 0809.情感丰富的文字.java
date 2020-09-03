/*
 * @lc app=leetcode.cn id=809 lang=java
 *
 * [809] 情感丰富的文字
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int expressiveWords(String S, String[] words) {
    RLE R = new RLE(S);
    int result = 0;

    search: for (String word : words) {
      RLE r = new RLE(word);
      if (!R.key.equals(r.key))
        continue;
      for (int i = 0; i < R.counts.size(); ++i) {
        int c1 = R.counts.get(i);
        int c2 = r.counts.get(i);
        if (c1 < 3 && c1 != c2 || c1 < c2)
          continue search;
      }
      result++;
    }
    return result;
  }
}

class RLE {
  String key;
  ArrayList<Integer> counts;

  public RLE(String S) {
    StringBuilder result = new StringBuilder();
    counts = new ArrayList<>();
    char[] array = S.toCharArray();
    int N = array.length;
    int prev = -1;
    for (int i = 0; i < N; ++i) {
      if (i == N - 1 || array[i] != array[i + 1]) {
        result.append(array[i]);
        counts.add(i - prev);
        prev = i;
      }
    }

    key = result.toString();
  }
}
// @lc code=end
