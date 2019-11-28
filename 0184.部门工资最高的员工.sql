--
-- @lc app=leetcode.cn id=184 lang=mysql
--
-- [184] 部门工资最高的员工
--
-- @lc code=start
# Write your MySQL query statement below
select
  d.Name as Department,
  e.Name as Employee,
  Salary
from (Department as d)
join(Employee as e) on e.DepartmentId = d.Id
where
  Salary = (
    select
      max(Salary)
    from Employee
    where
      DepartmentId = d.Id
  );
-- @lc code=end