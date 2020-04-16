/*
 * @lc app=leetcode.cn id=1311 lang=java
 *
 * [1311] 获取你好友已观看的视频
 */

// @lc code=start
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

class Pair {
  String name;
  int count;

  public Pair(String name, int count) {
    this.name = name;
    this.count = count;
  }
}


class Solution {
  public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends,
      int id, int level) {
    int n = watchedVideos.size();
    boolean[] visited = new boolean[n];
    visited[id] = true;
    LinkedList<Integer> queue = new LinkedList<>();
    queue.addFirst(id);
    for (int i = 0; i < level; i++) {
      int size = queue.size();
      for (int j = 0; j < size; j++) {
        int current = queue.pollLast();
        for (int next : friends[current]) {
          if (visited[next])
            continue;
          queue.addFirst(next);
          visited[next] = true;
        }
      }
    }
    HashMap<String, Integer> map = new HashMap<>();
    for (int value : queue)
      for (String name : watchedVideos.get(value))
        map.put(name, map.getOrDefault(name, 0) + 1);
    ArrayList<Pair> list = new ArrayList<>();
    for (String name : map.keySet())
      list.add(new Pair(name, map.get(name)));
    list.sort(new Comparator<Pair>() {
      @Override
      public int compare(Pair p1, Pair p2) {
        return p1.count != p2.count ? p1.count - p2.count : p1.name.compareTo(p2.name);
      }
    });
    return list.stream().map(x -> x.name).collect(Collectors.toList());
  }
}
// @lc code=end

