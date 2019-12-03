--
-- @lc app=leetcode.cn id=181 lang=mysql
--
-- [181] 超过经理收入的员工
--
-- @lc code=start
# Write your MySQL query statement below
select
  e.Name as Employee
from (Employee as e)
inner join (Employee as m) on e.ManagerId = m.Id
where
  e.Salary > m.Salary;
-- @lc code=end