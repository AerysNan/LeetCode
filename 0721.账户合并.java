/*
 * @lc app=leetcode.cn id=721 lang=java
 *
 * [721] 账户合并
 */

// @lc code=start
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Collections;

class DSU {
    int[] parent;

    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        HashMap<String, String> emailToName = new HashMap<>();
        HashMap<String, Integer> emailToID = new HashMap<>();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        HashMap<Integer, ArrayList<String>> result = new HashMap<>();
        for (String email : emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            result.computeIfAbsent(index, x -> new ArrayList<>()).add(email);
        }
        for (ArrayList<String> component : result.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList<>(result.values());
    }
}
// @lc code=end
