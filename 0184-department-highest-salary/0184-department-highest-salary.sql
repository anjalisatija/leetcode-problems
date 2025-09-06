/* Write your T-SQL query statement below */
SELECT d.name AS Department, e.name AS Employee, e.Salary
FROM Employee e
INNER JOIN Department d
ON e.departmentid = d.id
WHERE e.salary = (
    SELECT MAX(e1.salary)
    FROM Employee e1
    WHERE e1.departmentid = d.id
);
