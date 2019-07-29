/*
 * @lc app=leetcode.cn id=1138 lang=java
 *
 * [1138] 字母板上的路径
 */
class Solution {
  public String alphabetBoardPath(String target) {
    target = 'a' + target;
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < target.length() - 1; i++)
      builder.append(move(target.charAt(i) - 'a', target.charAt(i + 1) - 'a').toString()).append('!');
    return builder.toString();
  }

  StringBuilder move(int pos1, int pos2) {
    if (pos1 == pos2)
      return new StringBuilder("");
    StringBuilder builder = new StringBuilder();
    int r1 = pos1 / 5, c1 = pos1 % 5, r2 = pos2 / 5, c2 = pos2 % 5;
    int x = c2 - c1, y = r2 - r1;
    if (r1 == 5) {
      for (int i = 0; i < -y; i++)
        builder.append('U');
      for (int i = 0; i < x; i++)
        builder.append('R');
      return builder;
    }
    char xc = x > 0 ? 'R' : 'L', yc = y > 0 ? 'D' : 'U';
    for (int i = 0; i < Math.abs(x); i++)
      builder.append(xc);
    for (int i = 0; i < Math.abs(y); i++)
      builder.append(yc);
    return builder;
  }
}
