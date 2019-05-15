/*
 * @lc app=leetcode.cn id=1103 lang=java
 *
 * [1103] 分糖果 II
 */
class Solution {
  public int[] distributeCandies(int candies, int num_people) {
    int[] result = new int[num_people];
    int round = 0;
    while (true) {
      if (num_people * round * (round * num_people + 1) / 2 > candies)
        break;
      round++;
    }
    round--;
    int remain = candies - (num_people * round * (round * num_people + 1) / 2);
    for (int i = 0; i < num_people; i++)
      result[i] = (2 * i + 2 + (round - 1) * num_people) * round / 2;
    for (int i = 0; i < num_people; i++) {
      int value = i + 1 + num_people * round;
      if (value >= remain) {
        result[i] += remain;
        break;
      } else {
        result[i] += value;
        remain -= value;
      }
    }
    return result;
  }
}
