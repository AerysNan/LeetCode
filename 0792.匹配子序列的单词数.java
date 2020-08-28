/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] 匹配子序列的单词数
 */

// @lc code=start
import java.util.ArrayList;

class Node {
  String word;
  int index;

  public Node(String w, int i) {
    word = w;
    index = i;
  }
}

class Solution {
  public int numMatchingSubseq(String S, String[] words) {
    int result = 0;
    ArrayList<Node>[] heads = new ArrayList[26];
    for (int i = 0; i < 26; ++i)
      heads[i] = new ArrayList<Node>();
    for (String word : words)
      heads[word.charAt(0) - 'a'].add(new Node(word, 0));

    for (char c : S.toCharArray()) {
      ArrayList<Node> current = heads[c - 'a'];
      heads[c - 'a'] = new ArrayList<Node>();
      for (Node node : current) {
        node.index++;
        if (node.index == node.word.length())
          result++;
        else {
          heads[node.word.charAt(node.index) - 'a'].add(node);
        }
      }
    }
    return result;
  }

}
// @lc code=end
