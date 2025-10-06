# Write your MySQL query statement below
SELECT m.name
FROM Employee e, Employee m
WHERE m.id = e.managerId
GROUP BY e.managerId
HAVING COUNT(e.managerId) >= 5