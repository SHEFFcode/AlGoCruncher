# Write your MySQL query statement below
SELECT wt1.Id
FROM Weather wt1, Weather wt2
WHERE (wt1.temperature) > (wt2.temperature)
AND DATEDIFF(wt1.recorddate, wt2.recorddate) = 1