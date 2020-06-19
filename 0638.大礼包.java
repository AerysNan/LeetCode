/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        return shopping(price, special, needs, map);
    }

    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs,
            HashMap<List<Integer>, Integer> map) {
        if (map.containsKey(needs))
            return map.get(needs);
        int j = 0, result = dot(needs, price);
        for (List<Integer> s : special) {
            ArrayList<Integer> clone = new ArrayList<>(needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                result = Math.min(result, s.get(j) + shopping(price, special, clone, map));
        }
        map.put(needs, result);
        return result;
    }

    public int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++)
            sum += a.get(i) * b.get(i);
        return sum;
    }
}
// @lc code=end
