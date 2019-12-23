/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
import java.util.ArrayList;
import java.util.List;

class Node {
  Node[] children;
  String word;

  public Node() {
    children = new Node[26];
  }
}


class Solution {
  ArrayList<String> result;

  public List<String> findWords(char[][] board, String[] words) {
    Node root = build(words);
    result = new ArrayList<>();
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        dfs(board, i, j, root);
    return result;
  }

  void dfs(char[][] board, int i, int j, Node node) {
    char c = board[i][j];
    if (c == '#' || node.children[c - 'a'] == null)
      return;
    node = node.children[c - 'a'];
    if (node.word != null) {
      result.add(node.word);
      node.word = null;
    }
    board[i][j] = '#';
    if (i > 0)
      dfs(board, i - 1, j, node);
    if (j > 0)
      dfs(board, i, j - 1, node);
    if (i < board.length - 1)
      dfs(board, i + 1, j, node);
    if (j < board[0].length - 1)
      dfs(board, i, j + 1, node);
    board[i][j] = c;
  }

  Node build(String[] words) {
    Node root = new Node();
    for (String word : words) {
      Node current = root;
      for (char c : word.toCharArray()) {
        if (current.children[c - 'a'] == null)
          current.children[c - 'a'] = new Node();
        current = current.children[c - 'a'];
      }
      current.word = word;
    }
    return root;
  }
}
// @lc code=end

