/*
 * @lc app=leetcode.cn id=1300 lang=java
 *
 * [1300] 转变数组后最接近目标值的数组和
 */

// @lc code=start
import java.util.Arrays;

class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i)
            prefix[i] = prefix[i - 1] + arr[i - 1];
        int r = arr[n - 1];
        int result = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0)
                index = -index - 1;
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                result = i;
                diff = Math.abs(cur - target);
            }
        }
        return result;
    }
}
// @lc code=end
