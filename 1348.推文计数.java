/*
 * @lc app=leetcode.cn id=1348 lang=java
 *
 * [1348] 推文计数
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.List;

class TweetCounts {
  HashMap<String, TreeMap<Integer, Integer>> tweets;

  public TweetCounts() {
    tweets = new HashMap<>();
  }

  public void recordTweet(String tweetName, int time) {
    if (!tweets.containsKey(tweetName))
      tweets.put(tweetName, new TreeMap<>());
    TreeMap<Integer, Integer> map = tweets.get(tweetName);
    map.put(time, map.getOrDefault(time, 0) + 1);
  }

  public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime,
      int endTime) {
    ArrayList<Integer> result = new ArrayList<>();
    if (!tweets.containsKey(tweetName))
      return result;
    TreeMap<Integer, Integer> map = tweets.get(tweetName);
    int leap = 1;
    switch (freq) {
      case "minute":
        leap = 60;
        break;
      case "hour":
        leap = 3600;
        break;
      case "day":
        leap = 86400;
        break;
    }
    endTime++;
    while (startTime < endTime) {
      result.add(map.subMap(startTime, Math.min(startTime + leap, endTime)).size());
      startTime += leap;
    }
    return result;
  }
}

/**
 * Your TweetCounts object will be instantiated and called as such: TweetCounts obj = new
 * TweetCounts(); obj.recordTweet(tweetName,time); List<Integer> param_2 =
 * obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */
// @lc code=end

