/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists. // You should not implement it,
 * or speculate about its implementation public interface NestedInteger { // Constructor initializes
 * an empty nested list. public NestedInteger();
 *
 * // Constructor initializes a single integer. public NestedInteger(int value);
 *
 * // @return true if this NestedInteger holds a single integer, rather than a nested list. public
 * boolean isInteger();
 *
 * // @return the single integer that this NestedInteger holds, if it holds a single integer //
 * Return null if this NestedInteger holds a nested list public Integer getInteger();
 *
 * // Set this NestedInteger to hold a single integer. public void setInteger(int value);
 *
 * // Set this NestedInteger to hold a nested list and adds a nested integer to it. public void
 * add(NestedInteger ni);
 *
 * // @return the nested list that this NestedInteger holds, if it holds a nested list // Return
 * null if this NestedInteger holds a single integer public List<NestedInteger> getList(); }
 */
class Solution {
  public NestedInteger deserialize(String s) {
    if (s.length() == 0 || s.equals("[]"))
      return new NestedInteger();
    NestedInteger result = new NestedInteger();
    char[] chars = s.toCharArray();
    if (chars[0] == '[') {
      int elementStart = 1;
      while (elementStart < chars.length) {
        int elementEnd = searchForElementEnd(chars, elementStart);
        String nextListElement = new String(chars, elementStart, elementEnd - elementStart);
        result.add(deserialize(nextListElement));
        elementStart = elementEnd + 1;
      }
    } else
      result.setInteger(Integer.valueOf(s));
    return result;
  }

  private int searchForElementEnd(char[] chars, int elementStart) {
    int countBrackets = 0, index = elementStart;
    if (chars[index++] == '[')
      countBrackets++;
    while (index < chars.length) {
      char nextChar = chars[index];
      if (nextChar == ']') {
        countBrackets--;
        if (countBrackets <= 0) {
          if (countBrackets == 0)
            index++;
          break;
        }
      } else if (nextChar == '[')
        countBrackets++;
      else if (nextChar == ',' && countBrackets == 0)
        break;
      index++;
    }
    return index;
  }
}
// @lc code=end

