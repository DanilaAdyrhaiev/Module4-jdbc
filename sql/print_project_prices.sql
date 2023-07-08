select project.ID, TIMESTAMPDIFF(MONTH, project.START_DATE, project.FINISH_DATE) * SUM(worker.SALARY) AS cost
from project
inner join project_worker ON project.ID = project_worker.PROJECT_ID
inner join worker ON project_worker.WORKER_ID = worker.ID
group by project.ID, project.START_DATE, project.FINISH_DATE
order by cost desc;