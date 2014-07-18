--B9
select Admit.patID, pLastName || ', ' || pFirstName ||' '|| pMInit as pName, dName, 
	eLastName || ', ' || eFirstName ||' '|| eMInit as eName
from Admit join Patient using (patID)
	join Employee on Employee.empID = Admit.admitDocID
	join Diagnosis using (diagID)
	join
(
	select r.patID, recent, min(recent::date - r1.endTime::date) as time
	from
	(
		select patID, max(startTime) as recent
		from admit
		group by patID
	) as r
	join
	(
		select patID, startTime, endTime
		from admit
	) as r1
	using (patID)
	where r.recent != r1.startTime
	group by r.patID, recent
) as r2
on (r2.patID = Admit.patID and r2.recent = Admit.startTime)
where time < 30;

--B10
select patID, totalVisits, avgDuration, minSpan, avgSpan, maxSpan
from
(
	select patID, count(*) as totalVisits
	from Admit
	group by patID
)
as r1
left join
(
	select patID, avg(endTime::timestamp - startTime::timestamp) as avgDuration
	from Admit
	where endTime is not null
	group by patID
)
as r2
using (patID)
left join
(
	select patID, min(timeBetween) as minSpan
	from VisitIntervals
	group by patID
)
as r4
using (patID)
left join
(
	select patID, avg(timeBetween) as avgSpan
	from VisitIntervals
	group by patID
)
as r5
using (patID)
left join
(
	select patID, max(timeBetween) as maxSpan
	from VisitIntervals
	group by patID
)
as r6
using (patID)
order by patID;

--D1.
select *
from (select empID as ID, eLastName || ', ' || eFirstName || ' ' || eMInit as EmpName, eType as Type, eHiredate as DateOfHire
from Employee
union
select volID as ID, vLastName || ', ' || vFirstName || ' ' || vMInit as EmpName, 'Volunteer' as Type, vHiredate as DateOfHire
from Volunteer) workers
order by EmpName;

--D2.
select volID, vLastName || ', ' || vFirstName || ' ' || vMInit as Name
from Volunteer join VolProvide using (volID)
where servType = 'Info desk'
and dayOfWeek = 'Tue';

--D3.
select distinct eLastName || ', ' || eFirstName || ' ' || eMInit as docName, 
	pLastName || ', ' || pFirstName || ' ' || pMInit as patName, myYear
from Employee join Admit on (Employee.empID = Admit.admitDocID) join (select patID, extract(year from startTime::date) myYear
from Admit
group by patID, extract(year from startTime::date)
having count(extract(year from startTime::date)) >= 4) freqPatient using (patID) join Patient using (patID)
where freqPatient.myYear = extract(year from Admit.startTime::date);

--D4.
select eLastName || ', ' || eFirstName || ' ' || eMInit as Name, dName, diagCount
from Employee join (select admitDocID, diagID, count(diagID) diagCount
from Admit
where admitDocID = ?
group by admitDocID, diagID) diagInfo on (diagInfo.admitDocID = Employee.empID)
	join Diagnosis using (diagID)
order by diagCount desc;

--D5.
select eLastName || ', ' || eFirstName || ' ' || eMInit as Name, tName, treatCount
from Employee join (select empID, treatID, count(treatID) treatCount
from Orders
where empID = ?
group by empID, treatID) treatInfo using (empID)
	join Treatment using (treatID)
order by treatCount desc;

--D6.
select eLastName || ', ' || eFirstName || ' ' || eMInit as Name, tName, treatCount
from Employee join (select empAdministerID, treatID, count(treatID) treatCount
from Administers
where empAdministerID = ?
group by empAdministerID, treatID) treatInfo on (treatInfo.empAdministerID = Employee.empID)
	join Treatment using (treatID)
order by treatCount desc;
