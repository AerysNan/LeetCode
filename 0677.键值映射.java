/*
 * @lc app=leetcode.cn id=677 lang=java
 *
 * [677] 键值映射
 */

// @lc code=start
import java.util.HashMap;

class MapSum {

    HashMap<String, Integer> map;

    /** Initialize your data structure here. */
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);

    }

    public int sum(String prefix) {
        int result = 0;
        for (String key : map.keySet())
            if (key.startsWith(prefix))
                result += map.get(key);
        return result;
    }
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new
 * MapSum(); obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
// @lc code=end
