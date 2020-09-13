/*
 * @lc app=leetcode.cn id=843 lang=java
 *
 * [843] 猜猜这个单词
 */

// @lc code=start
/**
 * // This is the Master's API interface. // You should not implement it, or
 * speculate about its implementation interface Master { public int guess(String
 * word) {} }
 */
import java.util.ArrayList;

class Solution {
  int[][] H;

  public void findSecretWord(String[] wordlist, Master master) {
    int n = wordlist.length;
    H = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        int match = 0;
        for (int k = 0; k < 6; k++)
          if (wordlist[i].charAt(k) == wordlist[j].charAt(k))
            match++;
        H[i][j] = H[j][i] = match;
      }
    }
    ArrayList<Integer> possible = new ArrayList<>(), history = new ArrayList<>();
    for (int i = 0; i < n; i++)
      possible.add(i);
    while (!possible.isEmpty()) {
      int guess = solve(possible, history), matches = master.guess(wordlist[guess]);
      if (matches == wordlist[0].length())
        return;
      ArrayList<Integer> p = new ArrayList<>();
      for (int j : possible)
        if (H[guess][j] == matches)
          p.add(j);
      possible = p;
      history.add(guess);
    }
  }

  public int solve(ArrayList<Integer> possible, ArrayList<Integer> history) {
    if (possible.size() <= 2)
      return possible.get(0);
    ArrayList<Integer> g = possible;
    int result = -1;
    for (int guess = 0; guess < H.length; guess++) {
      if (history.contains(guess))
        continue;
      ArrayList<Integer>[] groups = new ArrayList[7];
      for (int i = 0; i < 7; i++)
        groups[i] = new ArrayList<Integer>();
      for (int j : possible)
        if (j != guess)
          groups[H[guess][j]].add(j);
      ArrayList<Integer> max = groups[0];
      for (int i = 0; i < 7; i++)
        if (groups[i].size() > max.size())
          max = groups[i];
      if (max.size() < g.size()) {
        g = max;
        result = guess;
      }
    }
    return result;
  }
}
// @lc code=end
