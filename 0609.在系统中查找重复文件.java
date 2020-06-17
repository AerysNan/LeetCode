/*
 * @lc app=leetcode.cn id=609 lang=java
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            for (int i = 1; i < values.length; i++) {
                String[] name_cont = values[i].split("\\(");
                name_cont[1] = name_cont[1].replace(")", "");
                List<String> list = map.getOrDefault(name_cont[1], new ArrayList<String>());
                list.add(values[0] + "/" + name_cont[0]);
                map.put(name_cont[1], list);
            }
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                result.add(map.get(key));
        }
        return result;
    }
}
// @lc code=end
