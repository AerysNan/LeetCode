/*
 * @lc app=leetcode.cn id=1032 lang=java
 *
 * [1032] 字符流
 */
class TrieTreeNode {
  TrieTreeNode[] children;
  boolean terminal;

  public TrieTreeNode() {
    this.children = new TrieTreeNode[26];
    this.terminal = false;
  }
}

class StreamChecker {

  TrieTreeNode head;
  StringBuilder stream;

  public StreamChecker(String[] words) {
    stream = new StringBuilder();
    head = new TrieTreeNode();
    for (String word : words)
      insert(head, word);
  }

  public boolean query(char letter) {
    stream.append(letter);
    return find(head, stream);
  }

  boolean find(TrieTreeNode head, StringBuilder s) {
    TrieTreeNode current = head;
    for (int i = s.length() - 1; i >= 0; i--) {
      if (current.terminal)
        return true;
      int index = s.charAt(i) - 'a';
      if (current.children[index] == null)
        return false;
      current = current.children[index];
    }
    return current.terminal;
  }

  void insert(TrieTreeNode head, String s) {
    TrieTreeNode current = head;
    for (int i = s.length() - 1; i >= 0; i--) {
      int index = s.charAt(i) - 'a';
      if (current.children[index] == null)
        current.children[index] = new TrieTreeNode();
      current = current.children[index];
    }
    current.terminal = true;
  }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words); boolean param_1 =
 * obj.query(letter);
 */
