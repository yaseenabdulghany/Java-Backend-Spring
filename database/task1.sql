-- create table manger
CREATE TABLE Manger (
    id NUMBER,
    name VARCHAR2(50),
    age NUMBER,
    birth_date DATE,
    address VARCHAR2(100)
);

-- drop address column
ALTER TABLE Manger DROP COLUMN address;

-- add city_address and street columns
ALTER TABLE Manger ADD (
    city_address VARCHAR2(100),
    street VARCHAR2(100)
);

-- rename column name to full_name
ALTER TABLE Manger RENAME COLUMN name TO full_name;

-- make table read only
ALTER TABLE Manger READ ONLY;

-- create owner table from manger with selected columns
CREATE TABLE Owner AS
SELECT id, full_name, birth_date
FROM Manger;

-- rename manger table to master
ALTER TABLE Manger RENAME TO Master;

-- drop all tables
DROP TABLE Master;
DROP TABLE Owner;



-- create table doctor
CREATE TABLE Doctor (
    id NUMBER,
    name VARCHAR2(50),
    salary NUMBER,
    address VARCHAR2(100)
);

-- insert 10 rows into doctor
INSERT INTO Doctor VALUES (1, 'Ahmed', 1000, 'Cairo');
INSERT INTO Doctor VALUES (2, 'Ali', 2000, 'Giza');
INSERT INTO Doctor VALUES (3, 'Omar', 1500, 'Alex');
INSERT INTO Doctor VALUES (4, 'Hassan', 3000, 'Mansoura');
INSERT INTO Doctor VALUES (5, 'Mahmoud', 2500, 'Tanta');
INSERT INTO Doctor VALUES (6, 'Youssef', 1800, 'Aswan');
INSERT INTO Doctor VALUES (7, 'Khaled', 2200, 'Luxor');
INSERT INTO Doctor VALUES (8, 'Ibrahim', 2700, 'Suez');
INSERT INTO Doctor VALUES (9, 'Mostafa', 3200, 'Ismailia');
INSERT INTO Doctor VALUES (10, 'Amr', 4000, 'Port Said');

COMMIT;

-- update record number 3 with salary 20000
UPDATE Doctor
SET salary = 20000
WHERE id = 3;

-- delete record number 9
DELETE FROM Doctor
WHERE id = 9;

-- concatenate all name with salary
SELECT name || ' - ' || salary AS name_salary
FROM Doctor;

-- display all records with salary * 2
SELECT id, name, salary * 2 AS doubled_salary, address
FROM Doctor;

-- select all data with salary 1000, 2000, 3000
SELECT *
FROM Doctor
WHERE salary IN (1000, 2000, 3000);

-- rename table doctor to prd_doctor
ALTER TABLE Doctor RENAME TO PRD_DOCTOR;



-- create employees table
CREATE TABLE Employees (
    EmployeeID NUMBER,
    FirstName VARCHAR2(50),
    LastName VARCHAR2(50),
    Department VARCHAR2(50),
    Salary NUMBER
);

-- insert records into employees table
INSERT INTO Employees VALUES (101, 'John1', 'Doe1', 'HR', 20000);
INSERT INTO Employees VALUES (102, 'John2', 'Doe2', 'IT', 50000);
INSERT INTO Employees VALUES (103, 'John3', 'Doe3', 'CS', 40000);
INSERT INTO Employees VALUES (104, 'John4', 'Doe4', 'IT', 10000);
INSERT INTO Employees VALUES (105, 'John5', 'Doe5', 'ZX', 30000);

COMMIT;

-- update the salary of employee with employeeid 101 to 600000
UPDATE Employees
SET Salary = 600000
WHERE EmployeeID = 101;

-- delete a record of an employee who department = 101
DELETE FROM Employees
WHERE Department = '101';

-- retrieve all employees in the it department
SELECT *
FROM Employees
WHERE Department = 'IT';

-- select all data with concatenation firstname and lastname as one column
SELECT EmployeeID,
       FirstName || ' ' || LastName AS FullName,
       Department,
       Salary
FROM Employees;
