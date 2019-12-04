--
-- @lc app=leetcode.cn id=182 lang=mysql
--
-- [182] 查找重复的电子邮箱
--
-- @lc code=start
# Write your MySQL query statement below
select
  distinct Email
from Person as p1
where
  (
    select
      count(*)
    from Person as p2
    where
      p1.Email = p2.Email
  ) > 1;
-- @lc code=end