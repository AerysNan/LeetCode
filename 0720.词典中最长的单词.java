/*
 * @lc app=leetcode.cn id=720 lang=java
 *
 * [720] 词典中最长的单词
 */

// @lc code=start
import java.util.HashMap;
import java.util.Stack;

class Solution {
  public String longestWord(String[] words) {
    Trie trie = new Trie();
    int index = 0;
    for (String word : words)
      trie.insert(word, ++index);
    trie.words = words;
    return trie.dfs();
  }
}


class Node {
  char c;
  HashMap<Character, Node> children = new HashMap<>();
  int index;

  public Node(char c) {
    this.c = c;
  }
}


class Trie {
  Node root;
  String[] words;

  public Trie() {
    root = new Node('0');
  }

  public void insert(String word, int index) {
    Node current = root;
    for (char c : word.toCharArray()) {
      current.children.putIfAbsent(c, new Node(c));
      current = current.children.get(c);
    }
    current.index = index;
  }

  public String dfs() {
    String result = "";
    Stack<Node> stack = new Stack<>();
    stack.push(root);
    while (!stack.empty()) {
      Node node = stack.pop();
      if (node.index > 0 || node == root) {
        if (node != root) {
          String word = words[node.index - 1];
          if (word.length() > result.length()
              || word.length() == result.length() && word.compareTo(result) < 0)
            result = word;
        }
        for (Node sub : node.children.values())
          stack.push(sub);
      }
    }
    return result;
  }
}
// @lc code=end

