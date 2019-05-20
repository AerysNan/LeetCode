import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=38 lang=java
 *
 * [38] 报数
 */
class Solution {
  String solve(String s) {
    String result = "";
    int index = 0, count = 0;
    char c = s.charAt(0);
    while (index < s.length()) {
      if (s.charAt(index) == c)
        count++;
      else {
        result = result + count + c;
        c = s.charAt(index);
        count = 1;
      }
      index++;
    }
    result = result + count + c;
    return result;
  }

  public String countAndSay(int n) {
    ArrayList<String> result = new ArrayList<>();
    result.add("1");
    for (int i = 1; i < n; i++)
      result.add(solve(result.get(i - 1)));
    return result.get(n - 1);
  }
}
