--
-- @lc app=leetcode.cn id=183 lang=mysql
--
-- [183] 从不订购的客户
--
-- @lc code=start
# Write your MySQL query statement below
select
  Name as Customers
from Customers as c
where
  not exists (
    select
      *
    from Orders
    where
      c.Id = CustomerId
  );
-- @lc code=end