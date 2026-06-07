
-- 1
SELECT *
FROM employees
WHERE emp_id BETWEEN 100 AND 105;

-- 2
SELECT *
FROM employees
WHERE emp_id IN (151, 152, 153, 154, 155);

-- 3
SELECT *
FROM employees
WHERE LOWER(first_name) LIKE 'p%';

-- 4
SELECT *
FROM employees
WHERE LOWER(first_name) LIKE '%a';

-- 5
SELECT *
FROM employees
WHERE LOWER(first_name) LIKE '%a%';

-- 6
SELECT *
FROM employees
WHERE LOWER(first_name) LIKE '__e%';

-- 7
SELECT *
FROM employees
WHERE manager_id IS NULL;

-- 8
SELECT *
FROM employees
WHERE manager_id IS NOT NULL;

-- 9
INSERT INTO employees (
    emp_id,
    first_name,
    last_name,
    email,
    hire_date,
    job_id,
    salary,
    manager_id,
    department_id
)
VALUES (
    999,
    'Ahmed',
    'Ali',
    'AHMEDALI',
    SYSDATE,
    'IT_PROG',
    5000,
    NULL,
    60
);

-- 10
SELECT *
FROM employees
WHERE job_id IN ('AD_VP', 'IT_PROG');

-- 11
SELECT *
FROM employees
ORDER BY last_name ASC;

-- 12
SELECT *
FROM employees
ORDER BY hire_date DESC;

-- 13
SELECT *
FROM employees
ORDER BY department_id ASC, salary DESC;

-- 14
SELECT LOWER(last_name) AS last_name_lowercase
FROM employees;

-- 15
SELECT UPPER(first_name) AS first_name_uppercase
FROM employees;

-- 16
SELECT INITCAP(first_name) AS first_name_title_case,
       INITCAP(last_name) AS last_name_title_case
FROM employees;

-- 17
SELECT *
FROM employees
WHERE LOWER(last_name) = 'smith';
