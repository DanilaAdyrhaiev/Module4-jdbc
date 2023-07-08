SELECT NAME as "Ім'я", SALARY as "Зарплатня" 
FROM worker 
where SALARY = (select max(SALARY) from worker)