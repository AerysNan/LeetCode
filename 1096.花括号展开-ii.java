import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=1096 lang=java
 *
 * [1096] 花括号展开 II
 */
class Solution {
  String expression;
  int index;

  ArrayList<String> produce(ArrayList<String> l1, ArrayList<String> l2) {
    if (l1.isEmpty())
      return l2;
    if (l2.isEmpty())
      return l1;
    ArrayList<String> result = new ArrayList<>();
    for (String s1 : l1)
      for (String s2 : l2)
        result.add(s1 + s2);
    return result;
  }

  ArrayList<String> parseUnion() {
    ArrayList<String> result = parseProduct();
    while (index < expression.length()) {
      if (expression.charAt(index) != ',')
        break;
      index++;
      result.addAll(parseProduct());
    }
    return result;
  }

  ArrayList<String> parseProduct() {
    ArrayList<String> result = new ArrayList<>();
    while (index < expression.length()) {
      if (expression.charAt(index) == '}' || expression.charAt(index) == ',')
        break;
      if (expression.charAt(index) == '{') {
        index++;
        result = produce(result, parseUnion());
        index++;
      } else {
        ArrayList<String> tmp = new ArrayList<>();
        String string = "";
        while (index < expression.length() && expression.charAt(index) >= 'a' && expression.charAt(index) <= 'z')
          string += expression.charAt(index++);
        tmp.add(string);
        result = produce(result, tmp);
      }
    }
    return result;
  }

  public List<String> braceExpansionII(String expression) {
    this.expression = expression;
    this.index = 0;
    HashSet<String> set = new HashSet<>(parseUnion());
    ArrayList<String> result = new ArrayList<>(set);
    Collections.sort(result);
    return result;
  }
}
