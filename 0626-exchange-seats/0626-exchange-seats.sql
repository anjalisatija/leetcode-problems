# Write your MySQL query statement below




SELECT id,
     (CASE WHEN (SELECT COUNT(id)%2 != 0 FROM Seat) 
     THEN
      (CASE WHEN id%2 = 0 AND id != (SELECT MAX(id) FROM Seat)
                  THEN LAG(student, 1, 0) OVER(ORDER BY id)
            WHEN id%2 != 0 AND id != (SELECT MAX(id) FROM Seat)
                  THEN LEAD(student, 1, 0) OVER(ORDER BY id)
            WHEN  id = (SELECT MAX(id) FROM Seat)
                  THEN student
            END)
      ELSE
       (CASE WHEN id%2 = 0 
                  THEN LAG(student, 1, 0) OVER(ORDER BY id)
                  ELSE LEAD(student, 1, 0) OVER(ORDER BY id)
            END)
            END)
       as student
FROM Seat



  



