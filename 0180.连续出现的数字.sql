--
-- @lc app=leetcode.cn id=180 lang=mysql
--
-- [180] 连续出现的数字
--
-- @lc code=start
# Write your MySQL query statement below
select
  distinct l1.Num as ConsecutiveNums
from Logs as l1
left join Logs as l2 on l1.Id = l2.Id - 1
left join Logs as l3 on l1.Id = l3.Id - 2
where
  l1.Num = l2.Num
  and l2.Num = l3.Num;
-- @lc code=end