INSERT into major(id, name) values (1, 'Computer Science');


INSERT into student(id, major_id, firstname, lastname, email, degree, status, position, immatriculationNumber, birthdate) values (1, 1, 'John', 'Doe', 'john.doe@thws.de', 'BSc', 'active', 'student', '123456', '1999-03-03');
INSERT into student(id, major_id, firstname, lastname, email, degree, status, position, immatriculationNumber, birthdate) values (2, 1, 'Jane', 'Doe', 'jane.doe@thws.de', 'BSc', 'active', 'student','234324', '2000-05-02');
INSERT into student(id, major_id, firstname, lastname, email, degree, status, position, immatriculationNumber, birthdate) values (3, 1, 'Mickey', 'Mouse', 'mickey.mouse@thws.de', 'MSc', 'active', 'Prof', '346543', '2001-05-15');
INSERT into student(id, major_id, firstname, lastname, email, degree, status, position, immatriculationNumber, birthdate) values (4, 1, 'John', 'Doe', 'john.doe@thws.de', 'BSc', 'active', 'student', '345345', '2002-07-18');

SELECT setval('student_seq', 100);