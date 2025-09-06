# Write your MySQL query statement below

select tt.name as Employee from (select t1.name, t1.salary, t2.salary as msa from Employee t1 left join Employee t2 
on t1.managerId = t2.id) tt where tt.salary > tt.msa
