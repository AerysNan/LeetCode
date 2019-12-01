--
-- @lc app=leetcode.cn id=178 lang=mysql
--
-- [178] 分数排名
--
-- @lc code=start
# Write your MySQL query statement below
select
  Score,
  (
    select
      count(distinct Score)
    from Scores
    where
      Score >= s.Score
  ) as Rank
from Scores as s
order by
  Score desc;
-- @lc code=end