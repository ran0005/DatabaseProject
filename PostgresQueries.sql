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
