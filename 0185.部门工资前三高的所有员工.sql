--
-- @lc app=leetcode.cn id=185 lang=mysql
--
-- [185] 部门工资前三高的所有员工
--
-- @lc code=start
# Write your MySQL query statement below
select
  d.Name as Department,
  e.Name as Employee,
  e.Salary
from (Department as d)
join (Employee as e) on e.DepartmentId = d.Id
where(
    select
      count(distinct Salary)
    from Employee
    where
      DepartmentId = d.Id
      and Salary > e.Salary
  ) < 3
order by
  Department;
-- @lc code=end