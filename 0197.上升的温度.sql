--
-- @lc app=leetcode.cn id=197 lang=mysql
--
-- [197] 上升的温度
--
-- @lc code=start
# Write your MySQL query statement below
select
  Id
from Weather as This
where
  This.Temperature > (
    select
      Temperature
    from Weather as Other
    where
      datediff(Other.RecordDate, This.RecordDate) = -1
  );
-- @lc code=end