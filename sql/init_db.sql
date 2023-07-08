create table worker(
ID int primary key auto_increment,
NAME varchar(1000) not null check(length(NAME) > 2), 
BIRTHDAY date check(year(BIRTHDAY) > 1900),
LEVEL enum('Trainee', 'Junior', 'Middle', 'Senior') not null,
SALARY int check (SALARY >=100 and SALARY <=100000)
);	

create table client(
ID int primary key auto_increment,
NAME varchar(1000) not null check(length(NAME) > 2));

create table project(
ID int primary key auto_increment,
CLIENT_ID int,
START_DATE date,
FINISH_DATE date,
foreign key (CLIENT_ID) references client(ID));

create table project_worker(
PROJECT_ID int,
WORKER_ID int,
primary key(PROJECT_ID, WORKER_ID),
foreign key(PROJECT_ID) references project(ID),
foreign key(WORKER_ID) references worker(ID)
);