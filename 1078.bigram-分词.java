import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1078 lang=java
 *
 * [1078] Bigram 分词
 */
class Solution {
  public String[] findOcurrences(String text, String first, String second) {
    ArrayList<String> a = new ArrayList<>();
    String[] list = text.split(" ");
    for (int i = 0; i < list.length - 2; i++)
      if (list[i].equals(first) && list[i + 1].equals(second))
        a.add(list[i + 2]);
    String[] result = new String[a.size()];
    for (int i = 0; i < result.length; i++)
      result[i] = a.get(i);
    return result;
  }
}
