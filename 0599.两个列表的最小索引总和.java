/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
import java.util.ArrayList;

class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        ArrayList<String> result = new ArrayList<>();
        for (int sum = 0; sum < list1.length + list2.length - 1; sum++) {
            for (int i = 0; i <= sum; i++)
                if (i < list1.length && sum - i < list2.length && list1[i].equals(list2[sum - i]))
                    result.add(list1[i]);
            if (!result.isEmpty())
                break;
        }
        return result.toArray(new String[result.size()]);
    }
}
// @lc code=end
