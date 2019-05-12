/*
 * @lc app=leetcode.cn id=1093 lang=java
 *
 * [1093] 大样本统计
 */
class Solution {
  public double[] sampleStats(int[] count) {
    double totValue = 0, medianValue = 0;
    int minValue = -1, maxValue = 0, modeValue = 0;
    int totCount = 0;
    for (int i = 0; i < 256; i++) {
      if (count[i] == 0)
        continue;
      if (minValue == -1)
        minValue = i;
      maxValue = i;
      totCount += count[i];
      totValue += i * count[i];
      if (modeValue < 0 || count[i] > count[modeValue])
        modeValue = i;
    }
    if (totCount % 2 == 0) {
      int accCount = 0, medianLo = -1, medianHi = -1;
      for (int i = 0; i < 256; i++) {
        if (count[i] == 0)
          continue;
        accCount += count[i];
        if (medianLo < 0 && accCount >= totCount / 2)
          medianLo = i;
        if (medianHi < 0 && accCount >= totCount / 2 + 1)
          medianHi = i;
      }
      medianValue = (medianLo + medianHi) / 2.0;
    } else {
      int accCount = 0;
      for (int i = 0; i < 256; i++) {
        if (count[i] == 0)
          continue;
        accCount += count[i];
        if (accCount >= totCount / 2 + 1) {
          medianValue = i;
          break;
        }
      }
    }
    return new double[] { minValue, maxValue, totValue / totCount, medianValue, modeValue };
  }
}
