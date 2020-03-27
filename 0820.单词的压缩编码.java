/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class TrieNode {
  TrieNode[] children;
  boolean leaf;

  public TrieNode() {
    children = new TrieNode[26];
    leaf = false;
  }
}


class TrieTree {
  TrieNode root;

  public TrieTree() {
    root = new TrieNode();
  }

  void intsert(String s) {
    TrieNode current = root;
    for (char c : s.toCharArray()) {
      if (current.children[c - 'a'] == null)
        current.children[c - 'a'] = new TrieNode();
      current = current.children[c - 'a'];
      current.leaf = false;
    }
    current.leaf = true;
  }

  boolean check(String s) {
    TrieNode current = root;
    for (char c : s.toCharArray()) {
      if (current.children[c - 'a'] == null)
        return false;
      current = current.children[c - 'a'];
    }
    return current.leaf;
  }
}


class Solution {
  public int minimumLengthEncoding(String[] words) {
    Arrays.sort(words, new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    });
    TrieTree tree = new TrieTree();
    HashSet<String> set = new HashSet<>();
    for (String word : words) {
      String reversed = new StringBuilder(word).reverse().toString();
      tree.intsert(reversed);
      set.add(reversed);
    }
    return set.stream().filter(x -> tree.check(x)).mapToInt(x -> x.length() + 1).sum();
  }
}
// @lc code=end

