/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Node {
  public char c;
  public Node[] children;
  public boolean terminate;

  public Node(char c) {
    this.c = c;
    children = new Node[26];
    this.terminate = false;
  }
}


class Trie {
  private Node root;

  /** Initialize your data structure here. */
  public Trie() {
    root = new Node(' ');
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (current.children[c - 'a'] == null)
        current.children[c - 'a'] = new Node(c);
      current = current.children[c - 'a'];
    }
    current.terminate = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    Node current = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (current.children[c - 'a'] == null)
        return false;
      current = current.children[c - 'a'];
    }
    return current.terminate;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    Node current = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (current.children[c - 'a'] == null)
        return false;
      current = current.children[c - 'a'];
    }
    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new Trie();
 * obj.insert(word); boolean param_2 = obj.search(word); boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

