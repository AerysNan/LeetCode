/*
 * @lc app=leetcode.cn id=916 lang=java
 *
 * [916] 单词子集
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> wordSubsets(String[] A, String[] B) {
    int[] max = new int[26];
    for (String b : B) {
      int[] count = count(b);
      for (int i = 0; i < 26; ++i)
        max[i] = Math.max(max[i], count[i]);
    }
    ArrayList<String> result = new ArrayList<>();
    loop: for (String a : A) {
      int[] count = count(a);
      for (int i = 0; i < 26; ++i)
        if (count[i] < max[i])
          continue loop;
      result.add(a);
    }
    return result;
  }

  public int[] count(String S) {
    int[] ans = new int[26];
    for (char c : S.toCharArray())
      ans[c - 'a']++;
    return ans;
  }
}
// @lc code=end

