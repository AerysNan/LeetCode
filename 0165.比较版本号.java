/*
 * @lc app=leetcode.cn id=165 lang=java
 *
 * [165] 比较版本号
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
  public int compareVersion(String version1, String version2) {
    ArrayList<Integer> nums1 = toList(version1), nums2 = toList(version2);
    int m = nums1.size(), n = nums2.size(), index1 = 0, index2 = 0;
    while (index1 < m || index2 < n) {
      if (index1 == m) {
        if (nums2.get(index2) == 0)
          index2++;
        else
          return -1;
      } else if (index2 == n) {
        if (nums1.get(index1) == 0)
          index1++;
        else
          return 1;
      } else {
        int value = Integer.compare(nums1.get(index1), nums2.get(index2));
        if (value != 0)
          return value;
        else {
          index1++;
          index2++;
        }
      }
    }
    return 0;
  }

  ArrayList<Integer> toList(String version) {
    int n = version.length(), begin = 0;
    ArrayList<Integer> result = new ArrayList<>();
    while (begin < n) {
      int end = begin;
      while (end != n && version.charAt(end) != '.')
        end++;
      result.add(Integer.parseInt(version.substring(begin, end)));
      begin = end + 1;
    }
    return result;
  }
}
// @lc code=end

