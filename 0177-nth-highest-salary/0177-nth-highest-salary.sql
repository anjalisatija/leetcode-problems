CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
  RETURN (
     SELECT salary  
     FROM (select salary, DENSE_RANK() OVER(ORDER BY salary DESC) as rnk FROM employee
     )  as rankedsalary
     WHERE rnk = N
     LIMIT 1

  );
END