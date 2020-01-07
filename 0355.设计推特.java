/*
 * @lc app=leetcode.cn id=355 lang=java
 *
 * [355] 设计推特
 */

// @lc code=start
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Tweet implements Comparable<Tweet> {
  int time;
  int userId;
  int tweetId;

  public Tweet(int time, int userId, int tweetId) {
    this.time = time;
    this.userId = userId;
    this.tweetId = tweetId;
  }

  @Override
  public int compareTo(final Tweet that) {
    return Integer.compare(this.time, that.time);
  }
}


class Twitter {
  int time;
  HashMap<Integer, HashSet<Integer>> userRelation;
  HashMap<Integer, ArrayList<Tweet>> postRelation;

  /** Initialize your data structure here. */
  public Twitter() {
    time = 0;
    userRelation = new HashMap<>();
    postRelation = new HashMap<>();
  }

  /** Compose a new tweet. */
  public void postTweet(final int userId, final int tweetId) {
    if (!userRelation.containsKey(userId))
      initRelation(userId);
    if (!postRelation.containsKey(userId))
      postRelation.put(userId, new ArrayList<>());
    postRelation.get(userId).add(new Tweet(time++, userId, tweetId));
  }

  /**
   * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must
   * be posted by users who the user followed or by the user herself. Tweets must be ordered from
   * most recent to least recent.
   */
  public List<Integer> getNewsFeed(final int userId) {
    if (!userRelation.containsKey(userId))
      return new ArrayList<>();
    PriorityQueue<Tweet> queue = new PriorityQueue<>();
    HashSet<Integer> followers = userRelation.get(userId);
    for (int user : followers) {
      if (!postRelation.containsKey(user))
        continue;
      ArrayList<Tweet> tweets = postRelation.get(user);
      // System.out.println(userId);
      // for (Tweet tweet : tweets)
      // System.out.print(tweet.tweetId + " ");
      // System.out.println();
      for (int i = tweets.size() - 1; i >= 0; i--) {
        if (queue.size() >= 10 && queue.peek().time > tweets.get(i).time)
          break;
        queue.add(tweets.get(i));
        if (queue.size() > 10)
          queue.poll();
      }
    }
    LinkedList<Integer> result = new LinkedList<>();
    while (!queue.isEmpty() && result.size() < 10)
      result.addFirst(queue.poll().tweetId);
    return result;
  }

  /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
  public void follow(final int followerId, final int followeeId) {
    if (!userRelation.containsKey(followerId))
      initRelation(followerId);
    userRelation.get(followerId).add(followeeId);
  }

  /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
  public void unfollow(final int followerId, final int followeeId) {
    if (followerId == followeeId)
      return;
    if (!userRelation.containsKey(followerId))
      initRelation(followerId);
    userRelation.get(followerId).remove(followeeId);
  }

  void initRelation(final int userId) {
    HashSet<Integer> followers = new HashSet<>();
    followers.add(userId);
    userRelation.put(userId, followers);
  }
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId); List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
// @lc code=end

