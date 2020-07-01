/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        char[] array = Integer.toString(num).toCharArray();
        int[] index = new int[10];
        for (int i = 0; i < array.length; i++)
            index[array[i] - '0'] = i;
        for (int i = 0; i < array.length; i++) {
            for (int d = 9; d > array[i] - '0'; d--) {
                if (index[d] <= i)
                    continue;
                char temp = array[i];
                array[i] = array[index[d]];
                array[index[d]] = temp;
                return Integer.valueOf(new String(array));
            }
        }
        return num;
    }
}
// @lc code=end
