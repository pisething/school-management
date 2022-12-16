-- Delete Data Every Time Application Start Up
delete from monthly_score;
delete from students;
delete from subjects;

-- Insert Students
INSERT INTO students(id, class_name, gender, grade, name) VALUES 
(1, 'A', 'MALE', 12, 'Dara'),
(2, 'A', 'FEMALE', 12, 'Thida'),
(3, 'A', 'FEMALE', 12, 'Cheata'),
(4, 'A', 'MALE', 12, 'Vannda'),
(5, 'A', 'MALE', 12, 'Ratha'),
(6, 'A', 'FEMALE', 12, 'Pheak'),
(7, 'A', 'FEMALE', 12, 'Dalin'),
(8, 'A', 'MALE', 12, 'Bora'),
(9, 'A', 'MALE', 12, 'Seyha'),
(10, 'A', 'FEMALE', 12, 'Nita');
ALTER SEQUENCE students_id_seq RESTART WITH 11;

-- Insert Subjects
INSERT INTO subjects(id, name) VALUES 
(1, 'Math'),
(2, 'Eng'),
(3, 'Thai'),
(4, 'Java'),
(5, 'Phy');

ALTER SEQUENCE subjects_id_seq RESTART WITH 6;

-- Add Monthly Score
INSERT INTO monthly_score(id, student_id, subject_id, year, month, score) VALUES 
(1, 1, 1, 2022, 10, 9),
(2, 1, 2, 2022, 10, 8),
(3, 1, 3, 2022, 10, 7),
(4, 1, 4, 2022, 10, 8),
(5, 1, 5, 2022, 10, 9),

(6, 2, 1, 2022, 10, 5),
(7, 2, 2, 2022, 10, 8),
(8, 2, 3, 2022, 10, 9),
(9, 2, 4, 2022, 10, 7),
(10, 2, 5, 2022, 10, 9),

(11, 3, 1, 2022, 10, 10),
(12, 3, 2, 2022, 10, 8),
(13, 3, 3, 2022, 10, 9),
(14, 3, 4, 2022, 10, 7),
(15, 3, 5, 2022, 10, 7),

(16, 1, 1, 2022, 11, 8),
(17, 1, 2, 2022, 11, 8),
(18, 1, 3, 2022, 11, 7),
(19, 1, 4, 2022, 11, 7),
(20, 1, 5, 2022, 11, 8),

(21, 2, 1, 2022, 11, 7),
(22, 2, 2, 2022, 11, 8),
(23, 2, 3, 2022, 11, 4),
(24, 2, 4, 2022, 11, 7),
(25, 2, 5, 2022, 11, 6),

(26, 3, 1, 2022, 11, 10),
(27, 3, 2, 2022, 11, 9),
(28, 3, 3, 2022, 11, 6),
(29, 3, 4, 2022, 11, 7),
(30, 3, 5, 2022, 11, 8);

ALTER SEQUENCE monthly_score_id_seq RESTART WITH 31;







