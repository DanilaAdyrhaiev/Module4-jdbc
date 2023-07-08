select client.NAME as name, count(*) as project_count
from client, project
where client.ID = project.CLIENT_ID
group by name
having count(*) = (
	select max(project_count)
	from
		(select COUNT(*) as project_count
		from project
		group by CLIENT_ID) as project_counts);