import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */
class Solution {
  public String simplifyPath(String path) {
    String[] paths = path.split("/");
    LinkedList<String> list = new LinkedList<>();
    for (String p : paths) {
      if (p.equals(".") || p.isEmpty())
        continue;
      if (p.equals("..")) {
        if (!list.isEmpty())
          list.pollLast();
      } else
        list.addLast(p);
    }
    if (list.isEmpty())
      return "/";
    String result = "";
    for (String p : list)
      result += "/" + p;
    return result;
  }
}
