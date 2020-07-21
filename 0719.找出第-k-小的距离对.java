/*
 * @lc app=leetcode.cn id=719 lang=java
 *
 * [719] 找出第 k 小的距离对
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1] - nums[0];
        while (l < r) {
            int mid = (l + r) / 2;
            int count = 0, begin = 0;
            for (int end = 0; end < nums.length; end++) {
                while (nums[end] - nums[begin] > mid)
                    begin++;
                count += end - begin;
            }
            if (count >= k)
                r = mid;
            else
                l = mid + 1;
        }
        return l;
    }
}
// @lc code=end
