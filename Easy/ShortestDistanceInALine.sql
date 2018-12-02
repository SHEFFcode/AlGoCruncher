# Write your MySQL query statement below
SELECT MIN(ABS(p1.x-p2.x)) as shortest
from point p1, point p2
where p1.x!=p2.x