/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
import java.util.HashMap;
import java.util.HashSet;

class WordDictionary {
  HashMap<Integer, HashSet<String>> map;

  /** Initialize your data structure here. */
  public WordDictionary() {
    map = new HashMap<>();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    int n = word.length();
    if (!map.containsKey(n))
      map.put(n, new HashSet<>());
    map.get(n).add(word);
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to
   * represent any one letter.
   */
  public boolean search(String word) {
    int n = word.length();
    if (!map.containsKey(n))
      return false;
    HashSet<String> set = map.get(n);
    if (!word.contains("."))
      return set.contains(word);
    for (String s : set)
      if (match(s, word))
        return true;
    return false;
  }

  boolean match(String s, String t) {
    int n = s.length();
    for (int i = 0; i < n; i++)
      if (t.charAt(i) != '.' && t.charAt(i) != s.charAt(i))
        return false;
    return true;
  }
}

/**
 * Your WordDictionary object will be instantiated and called as such: WordDictionary obj = new
 * WordDictionary(); obj.addWord(word); boolean param_2 = obj.search(word);
 */
// @lc code=end

