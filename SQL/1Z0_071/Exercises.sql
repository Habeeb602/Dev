-- 1. Null values with any arithmetic operation gives NULL

select FIRST_NAME, LAST_NAME, job_id ,commission_pct, commission_pct + 5.5 from employees;

select * from jobs;

-- 2. Column Alias

select LAST_NAME, LAST_NAME AS name, LAST_NAME lname, LAST_NAME " LASt-Name" from employees;

-- Concatenation

select FIRST_NAME, LAST_NAME, FIRST_NAME||LAST_NAME "full name", FIRST_NAME||' '||LAST_NAME "Full Name with space"
FROM employees;

-- Quotation -> q'[]' or q'()'

select first_name||' '||last_name||q'['s department is ]'||department_id from employees;

-- DISTINCT Keyword

select distinct department_id from employees;


-- DESCRIBE, DESC Keyword

DESCRIBE employees;
DESC employees;

/*
    SELECT Statement is the combination of both Projection & Selection
    - Projection is of selecting columns
    - Selection is of selecting rows
*/


-- Restricting & Sorting Data

/*
EMPLOYEE Table columns
EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER,HIRE_DATE,JOB_ID,SALARY,COMMISSION_PCT,MANAGER_ID,DEPARTMENT_ID 
*/


select * 
from employees 
where department_id=90;


select FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER
from employees
where FIRST_NAME= INITCAP('Steven');


select FIRST_NAME,LAST_NAME,EMAIL,PHONE_NUMBER
from employees
where FIRST_NAME= INITCAP('steven');


/*
Default date format in Oracle sql is
    DD-MON-RR
*/


select *
from employees
where hire_date='21-09-05';

select *
from employees
where hire_date < add_months(sysdate,-255);


/*
Escaping / in LIKE condition
*/

select *
from jobs
where job_id like 'SA/_%' escape '/';

-- Null values always appear last during order_by ascending

select *
from employees
order by commission_pct;

-- Descending will give the reverse

select *
from employees
order by commission_pct desc;


-- we can override the default order_by using NULLS FIRST/LAST
-- Returns nulls first and values in ascending order
select *
from employees
order by commission_pct NULLS FIRST;

-- Order by alias

SELECT first_name fn, last_name ln, hire_date 
FROM employees
ORDER BY fn;

-- Order by column-order number
-- Ordering by salary
SELECT first_name, last_name, salary, job_id
FROM employees
order by 3;


SELECT first_name, last_name, salary, job_id
FROM employees
order by 1,3;

select *
from employees
order by salary
fetch first 5 row only;


select * from hr.employees
order by salary desc
offset 1 rows fetch next 1 rows only;


select * from hr.employees
order by salary desc
fetch first 5 rows only;

select * from hr.employees
order by salary desc
fetch first 50 percent rows only;

-- here the percent means the percentage of the whole table rows, not the remaining records after offset

select * from hr.employees
order by salary desc
offset 5 rows fetch first 50 percent rows only;


-- this will retrieve extra rows (i.e. more than 2 rows), if it has matching salaries

select * from hr.employees
order by salary desc
fetch first 2 rows with ties;



-- New Chapter: 6
-- Substitution variables
-- temporarily store values in single ampersand ($) and double ampersand ($$) variables
-- these variables can be used in 
-- 1. where clauses
-- 2. order by 
-- 3. table name
-- 4. column expression
-- 5. select statements

select * from employees
where employee_id = &employee_id;


-- use quotes for varchar types
select employee_id, first_name, last_name, salary
from employees
where last_name = '&last_name'
order by 2;


-- &column_name -> salary, &condition -> salary>10000, $order_by -> first_name
select employee_id, first_name, last_name, &column_name, job_id
from employees
where &condition
order by &order_by; 


-- DEFINE & UNDEFINE
-- Defined varibale will only applicable for the current session
-- If connection lost, the variables will be destroyed

define employee_num = 100;

select employee_id, first_name, last_name, salary, job_id
from employees
where employee_id = &employee_num;

undefine employee_num;


-- ACCEPT & PROMPT

accept dept_id prompt