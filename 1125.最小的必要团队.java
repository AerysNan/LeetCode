import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1125 lang=java
 *
 * [1125] 最小的必要团队
 */
class Solution {
  public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
    int n = req_skills.length, size = 1 << n, m = people.size();
    HashMap<String, Integer> map = new HashMap<>();
    for (int i = 0; i < n; i++)
      map.put(req_skills[i], i);
    int[] skills = new int[m];
    for (int i = 0; i < m; i++) {
      int value = 0;
      for (String s : people.get(i))
        value |= 1 << map.get(s);
      skills[i] = value;
    }
    int[] dp = new int[size];
    int[] pick = new int[size];
    int[] prev = new int[size];
    prev[0] = -1;
    for (int i = 1; i < size; i++)
      dp[i] = Integer.MAX_VALUE;
    dp[0] = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < size; j++) {
        if (dp[j] == Integer.MAX_VALUE)
          continue;
        int newSkill = j | skills[i];
        if (dp[newSkill] > dp[j] + 1) {
          pick[newSkill] = i;
          prev[newSkill] = j;
          dp[newSkill] = dp[j] + 1;
        }
      }
    }
    ArrayList<Integer> list = new ArrayList<>();
    int index = size - 1;
    while (index > 0) {
      list.add(pick[index]);
      index = prev[index];
    }
    int[] result = new int[list.size()];
    for (int i = 0; i < list.size(); i++)
      result[i] = list.get(i);
    return result;
  }
}
