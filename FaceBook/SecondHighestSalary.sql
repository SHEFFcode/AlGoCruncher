SELECT MAX(salary) as SecondHighestSalary FROM Employee
WHERE Salary NOT IN 
    (SELECT Max(Salary) FROM Employee);