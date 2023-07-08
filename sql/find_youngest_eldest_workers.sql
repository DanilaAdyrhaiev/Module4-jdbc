select 'YOUNGEST' as TYPE, NAME, BIRTHDAY
from worker
where BIRTHDAY = (select min(BIRTHDAY)
from worker)

union

select 'OLDEST' as TYPE, NAME, BIRTHDAY
from worker
where BIRTHDAY = (select max(BIRTHDAY)
from worker)