/*
 * @lc app=leetcode.cn id=472 lang=java
 *
 * [472] 连接词
 */

// @lc code=start
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TrieNode {
  public TrieNode[] children;
  public boolean leaf;

  public TrieNode() {
    children = new TrieNode[26];
  }
}


class Solution {
  TrieNode root = new TrieNode();

  public List<String> findAllConcatenatedWordsInADict(String[] words) {
    ArrayList<String> result = new ArrayList<>();
    root.leaf = true;
    for (String word : words) {
      TrieNode current = root;
      for (char c : word.toCharArray()) {
        if (current.children[c - 'a'] == null)
          current.children[c - 'a'] = new TrieNode();
        current = current.children[c - 'a'];
      }
      current.leaf = true;
    }
    for (String word : words)
      if (search(root, word.toCharArray(), 0, 0))
        result.add(word);
    return result;
  }

  boolean search(TrieNode node, char[] array, int index, int count) {
    for (int i = index; i < array.length; i++) {
      if (node.children[array[i] - 'a'] == null)
        return false;
      node = node.children[array[i] - 'a'];
      if (!node.leaf)
        continue;
      if (search(root, array, i + 1, count + 1))
        return true;
    }
    return node.leaf && count > 1;
  }
}
// @lc code=end

