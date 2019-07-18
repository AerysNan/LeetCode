import java.util.Arrays;
import java.util.Comparator;

/*
 * @lc app=leetcode.cn id=1044 lang=java
 *
 * [1044] 最长重复子串
 */
class Solution {
  class Suffix {
    int index;
    int rank1;
    int rank2;

    public Suffix(int index, int rank1, int rank2) {
      this.index = index;
      this.rank1 = rank1;
      this.rank2 = rank2;
    }
  }

  public String longestDupSubstring(String S) {
    char[] array = S.toCharArray();
    int[] suffix = buildSuffix(array);
    int[] lcs = buildLCS(array, suffix);
    int maxLen = -1, index = -1;
    for (int i = 0; i < suffix.length - 1; i++) {
      if (lcs[i] > maxLen) {
        maxLen = lcs[i];
        index = suffix[i];
      }
    }
    return S.substring(index, index + maxLen);
  }

  int[] buildSuffix(char[] array) {
    int n = array.length;
    Suffix[] suffixs = new Suffix[n];
    Comparator<Suffix> comparator = new Comparator<Suffix>() {
      @Override
      public int compare(Suffix s1, Suffix s2) {
        if (s1.rank1 != s2.rank1)
          return s1.rank1 - s2.rank1;
        return s1.rank2 - s2.rank2;
      }
    };
    for (int i = 0; i < n; i++)
      suffixs[i] = new Suffix(i, array[i] - 'a', i + 1 < n ? (array[i + 1] - 'a') : -1);
    Arrays.sort(suffixs, comparator);
    int[] indexes = new int[n];
    for (int k = 4; k < 2 * n; k *= 2) {
      int rank = 0, prev = suffixs[0].rank1;
      suffixs[0].rank1 = 0;
      indexes[suffixs[0].index] = 0;
      for (int i = 1; i < n; i++) {
        if (suffixs[i].rank1 == prev && suffixs[i].rank2 == suffixs[i - 1].rank2) {
          prev = suffixs[i].rank1;
          suffixs[i].rank1 = rank;
        } else {
          prev = suffixs[i].rank1;
          suffixs[i].rank1 = ++rank;
        }
        indexes[suffixs[i].index] = i;
      }
      for (int i = 0; i < n; i++) {
        int next = suffixs[i].index + k / 2;
        suffixs[i].rank2 = next < n ? suffixs[indexes[next]].rank1 : -1;
      }
      Arrays.sort(suffixs, comparator);
    }
    int[] result = new int[n];
    for (int i = 0; i < n; i++)
      result[i] = suffixs[i].index;
    return result;
  }

  int[] buildLCS(char[] array, int[] suffix) {
    int n = array.length;
    int[] lcs = new int[n];
    int[] inv = new int[n];
    for (int i = 0; i < n; i++)
      inv[suffix[i]] = i;
    int k = 0;
    for (int i = 0; i < n; i++) {
      if (inv[i] == n - 1) {
        k = 0;
        continue;
      }
      int j = suffix[inv[i] + 1];
      while (i + k < n && j + k < n && array[i + k] == array[j + k])
        k++;
      lcs[inv[i]] = k;
      if (k > 0)
        k--;
    }
    return lcs;
  }
}
