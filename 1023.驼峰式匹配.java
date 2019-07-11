import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1023 lang=java
 *
 * [1023] 驼峰式匹配
 */
class Solution {
  boolean match(String q, String p) {
    int i = 0, j = 0;
    while (i < q.length() && j < p.length()) {
      if (q.charAt(i) == p.charAt(j)) {
        i++;
        j++;
      } else {
        if (q.charAt(i) >= 'A' && q.charAt(i) <= 'Z')
          return false;
        else
          i++;
      }
    }
    if (j != p.length())
      return false;
    while (i < q.length())
      if (q.charAt(i) >= 'A' && q.charAt(i++) <= 'Z')
        return false;
    return true;
  }

  public List<Boolean> camelMatch(String[] queries, String p) {
    ArrayList<Boolean> result = new ArrayList<>();
    for (String q : queries)
      result.add(match(q, p));
    return result;
  }
}
