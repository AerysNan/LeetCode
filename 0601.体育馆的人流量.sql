--
-- @lc app=leetcode.cn id=601 lang=mysql
--
-- [601] 体育馆的人流量
--

-- @lc code=start
# Write your MySQL query statement below

select distinct t1.*
from stadium t1, stadium t2, stadium t3
where
  t1.people >= 100 and t2.people >= 100 and t3.people >= 100 and (
	  t1.id - t2.id = 1 and t1.id - t3.id = 2 and t2.id - t3.id =1 or
    t2.id - t1.id = 1 and t2.id - t3.id = 2 and t1.id - t3.id =1 or
    t3.id - t2.id = 1 and t2.id - t1.id =1 and t3.id - t1.id = 2
  )
order by t1.id;

-- @lc code=end

