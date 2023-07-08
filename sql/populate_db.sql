insert worker(NAME, BIRTHDAY, LEVEL, SALARY) 
values
("Dan", '2002-11-07', 'Senior', 99000),
("Ivan", '2000-12-17', 'Junior', 12000),
("Maks", '1994-01-23', 'Middle', 4000),
("Vika", '2001-11-10', 'Middle', 5000),
("George", '2004-12-15', 'Trainee', 900),
("Victor", '2000-05-02', 'Junior', 12000),
("Kate", '1992-08-01', 'Senior', 90000),
("Lisa", '1994-03-04', 'Junior', 12000),
("Victoria", '1991-09-01', 'Middle', 45000),
("Vlad", '1971-12-17', 'Senior', 99000);

insert client(NAME)
values("Mark"),("Steve"),("John"),("Mary"),("Tony");

insert project(CLIENT_ID, START_DATE, FINISH_DATE)
values
(1, '2020-12-01', '2021-07-15'),
(2, '2021-01-01', '2021-02-01'),
(3, '2021-01-15', '2021-05-13'),
(4, '2021-03-11', '2022-06-12'),
(5, '2022-10-15', '2023-06-03');

insert project_worker(project_ID, WORKER_ID)
values
(1, 5), (1,6),
(2, 4), (2, 7),
(3, 3), (3,8),
(4, 2), (4, 9),
(5, 1), (5, 10);