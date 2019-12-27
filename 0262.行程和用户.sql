--
-- @lc app=leetcode.cn id=262 lang=mysql
--
-- [262] 行程和用户
--
-- @lc code=start
# Write your MySQL query statement below
select
  t.Request_at as Day,
  round(
    sum(
      (
        case
          when t.Status like 'cancelled%' then 1
          else 0
        end
      )
    ) / count(*),
    2
  ) as 'Cancellation Rate'
from Trips t
inner join Users u on u.Users_Id = t.Client_Id
  and u.Banned = 'No'
where
  t.Request_at between '2013-10-01'
  and '2013-10-03'
group by
  t.Request_at;
-- @lc code=end