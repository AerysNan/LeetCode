/*
 * @lc app=leetcode.cn id=336 lang=java
 *
 * [336] 回文对
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
  public List<List<Integer>> palindromePairs(String[] words) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    if (words == null || words.length == 0)
      return res;
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < words.length; i++)
      map.put(words[i], i);
    if (map.containsKey("")) {
      int blankIdx = map.get("");
      for (int i = 0; i < words.length; i++) {
        if (isPalindrome(words[i])) {
          if (i == blankIdx)
            continue;
          res.add(Arrays.asList(blankIdx, i));
          res.add(Arrays.asList(i, blankIdx));
        }
      }
    }
    for (int i = 0; i < words.length; i++) {
      String str = reverseStr(words[i]);
      if (map.containsKey(str)) {
        int found = map.get(str);
        if (found == i)
          continue;
        res.add(Arrays.asList(i, found));
      }
    }
    for (int i = 0; i < words.length; i++) {
      String cur = words[i];
      for (int cut = 1; cut < cur.length(); cut++) {
        if (isPalindrome(cur.substring(0, cut))) {
          String cut_r = reverseStr(cur.substring(cut));
          if (map.containsKey(cut_r)) {
            int found = map.get(cut_r);
            if (found == i)
              continue;
            res.add(Arrays.asList(found, i));
          }
        }
        if (isPalindrome(cur.substring(cut))) {
          String cut_r = reverseStr(cur.substring(0, cut));
          if (map.containsKey(cut_r)) {
            int found = map.get(cut_r);
            if (found == i)
              continue;
            res.add(Arrays.asList(i, found));
          }
        }
      }
    }
    return res;
  }

  public String reverseStr(String str) {
    return new StringBuilder(str).reverse().toString();
  }

  public boolean isPalindrome(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j))
        return false;
      i++;
      j--;
    }
    return true;
  }
}
// @lc code=end

