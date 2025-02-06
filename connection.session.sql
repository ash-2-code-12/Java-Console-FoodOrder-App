-- Create the database and use it
-- CREATE DATABASE ZSGS;
USE ZSGS;

-- Drop the table if it exists 
DROP TABLE IF EXISTS Marks;

-- Create the table
CREATE TABLE Marks (
    Student_Id INT NOT NULL PRIMARY KEY,
    Student_Name VARCHAR(20),
    Maths TINYINT,
    English TINYINT,
    CompSci TINYINT,
    SocialSci TINYINT,
    Science TINYINT
);

-- Insert data into the table
INSERT INTO Marks (Student_Id, Student_Name, Maths, English, CompSci, SocialSci, Science) VALUES
(111, 'Ashwin', 91, 89, 87, 92, 95),
(125, 'Vengat', 83, 79, 81, 97, 82),
(172, 'Surya', 90, 87, 75, 94, 82),
(103, 'Ramachandran', 83, 79, 80, 87, 99),
(177, 'Saran Chakaravarthy', 91, 85, 89, 93, 91),
(201, 'Ananya', 85, 90, 88, 84, 92),
(202, 'Ravi', 78, 83, 80, 77, 85),
(203, 'Preity', 91, 89, 94, 92, 90),
(204, 'Arjun', 75, 80, 78, 83, 88),
(205, 'Nina', 88, 92, 90, 85, 87),
(206, 'Kiran', 82, 79, 84, 90, 80),
(207, 'Shree', 84, 91, 92, 96, 89),
(208, 'Raj', 77, 80, 75, 78, 82),
(209, 'Maya', 89, 93, 91, 90, 90),
(210, 'Vikram', 80, 85, 86, 81, 88),
(211, 'Anil', 65, 70, 72, 68, 60),
(212, 'Rina', 50, 55, 60, 58, 62),
(213, 'Rajesh', 45, 50, 55, 52, 48),
(214, 'Meera', 30, 35, 40, 38, 32),
(215, 'Amit', 20, 25, 30, 28, 22);
-- Add the Total column
ALTER TABLE Marks ADD COLUMN Total SMALLINT;

-- Update the Total column with the sum of marks
UPDATE Marks 
SET Total = Maths + English + CompSci + SocialSci + Science;

-- Add the Average column
ALTER TABLE Marks ADD COLUMN Average TINYINT;

-- Update the Average column with average;
UPDATE Marks
SET Average = Total/5;

-- Add the GRADE column
ALTER TABLE Marks ADD COLUMN Grade CHAR(1);

-- Assign Grade based on Averag : 
Update Marks
SET Grade = CASE
	WHEN Average >= 90 THEN 'A'
    WHEN Average >= 80 THEN 'B'
    WHEN Average >= 70 THEN 'C'
    WHEN Average >= 60 THEN 'D'
    WHEN Average >= 40 THEN 'E'
    WHEN Average < 40 OR (Maths<40 OR English<40 OR CompSci<40 OR SocialSci<40 OR Science<40 ) THEN 'F'
END;
-- SELECT * FROM Marks ORDER BY Total DESC;

SELECT * FROM Marks ORDER BY Total DESC;
