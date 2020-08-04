/*
 * @lc app=leetcode.cn id=745 lang=java
 *
 * [745] 前缀和后缀搜索
 */

// @lc code=start
class WordFilter {
    TrieNode trie;

    public WordFilter(String[] words) {
        trie = new TrieNode();
        for (int weight = 0; weight < words.length; weight++) {
            String word = words[weight] + "{";
            for (int i = 0; i < word.length(); i++) {
                TrieNode current = trie;
                current.weight = weight;
                for (int j = i; j < 2 * word.length() - 1; j++) {
                    int k = word.charAt(j % word.length()) - 'a';
                    if (current.children[k] == null)
                        current.children[k] = new TrieNode();
                    current = current.children[k];
                    current.weight = weight;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        TrieNode current = trie;
        for (char letter : (suffix + '{' + prefix).toCharArray()) {
            if (current.children[letter - 'a'] == null)
                return -1;
            current = current.children[letter - 'a'];
        }
        return current.weight;
    }
}

class TrieNode {
    TrieNode[] children;
    int weight;

    public TrieNode() {
        children = new TrieNode[27];
        weight = 0;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such: WordFilter
 * obj = new WordFilter(words); int param_1 = obj.f(prefix,suffix);
 */
// @lc code=end
