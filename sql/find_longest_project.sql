select id as name, timestampdiff(MONTH, project.start_date, project.finish_date) AS MONTH_COUNT
from project
where datediff(FINISH_DATE, START_DATE) = (select max(datediff(FINISH_DATE, START_DATE)) from project);