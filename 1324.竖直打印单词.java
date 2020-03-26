/*
 * @lc app=leetcode.cn id=1324 lang=java
 *
 * [1324] 竖直打印单词
 */

// @lc code=start
class Solution {
  public List<String> printVertically(String s) {
    String[] words = s.split(" ");
    int n = words.length, length = Arrays.stream(words).mapToInt(x -> x.length()).max().getAsInt();
    ArrayList<StringBuilder> map = new ArrayList<>();
    for (int i = 0; i < length; i++)
      map.add(new StringBuilder());
    for (int i = 0; i < length; i++) {
      int bound = n - 1;
      while (i >= words[bound].length())
        bound--;
      for (int j = 0; j <= bound; j++)
        map.get(i).append(i >= words[j].length() ? ' ' : words[j].charAt(i));
    }
    return map.stream().map(x -> x.toString()).collect(Collectors.toList());
  }
}
// @lc code=end

