/* A1. List the rooms that are occupied, along with the associated patient names 
and the date the patient was admitted. */
select roomNum, pLastName || ', ' || pFirstName || ' ' || pMInit as Name, startTime
from patient join
(
	select roomNum, patID, startTime
	from admit join
	(
		select roomNum, patID
		from Room
		where patID IS NOT NULL
	) as a1 using (patID)
	where endTime IS NULL
) as a2 using (patID)
order by roomNum;

-- A2. List the rooms that are currently unoccupied.
select roomNum
from Room
where patID IS NULL;

/* A3. List all rooms in the hospital along with patient names and admission dates 
for those that are occupied. */
select roomNum, pLastName || ', ' || pFirstName || ' ' || pMInit as Name, startTime
from room left join
(
	select patID, pFirstName, pMInit, pLastName, startTime
	from patient join
	(
		select patID, startTime
		from admit
		where endTime IS NULL
	) as p1 using (patID)
) as p2 using (patID);

/* C6. List the treatments performed on outpatients, in descending order of occurrences. 
List treatment identification number, name, and total number of occurrences of each 
treatment. */
select treatID, tName, occurrences
from treatment join
(
	select treatID, COUNT(treatID) as occurrences
	from adminsters join
	(
		select patID
		from admit
		where patType = 'out'
	) as a1 using (patID)
	group by treatID
) as t1 using (treatID)
order by occurrences;

/* C7. List the diagnoses associated with patients who have the highest occurrences 
of admissions to the hospital, in ascending order or correlation. */
select dName
from diagnosis join
(
	select diagID
	from admit join
	(
		select patID, COUNT(patID) as admissions
		from admit
		where admissions = (select MAX(admissions) from (
			select patID, COUNT(patID) as admissions
			from admit
			group by patID
			) as a1)
		group by patID
	) as a2 using (patID)
) as d1 using (diagID);

---
--OR
---

/* C7. List the diagnoses associated with patients who have the highest occurrences 
of admissions to the hospital, in ascending order or correlation. */
select dName
from diagnosis join
(
	select patID, diagID
	from admit join
	(
		select patID, COUNT(patID) as admissions
		from admit
		group by patID
		having count(patID) = (select MAX(admissions) from (
			select patID, COUNT(patID) as admissions
			from admit
			group by patID
			) as a1)
	) as a2 using (patID)
) as d1 using (diagID)
group by dName
order by count(dName);

/* C8. For a given treatment occurrence, list all the hospital employees that were 
involved. Also include the patient name and the doctor who ordered the treatment. */
select docName, patName,
eLastName || ', ' || eFirstName || ' ' || eMInit as empName
from employee join
(
	select eLastName || ', ' || eFirstName || ' ' || eMInit as docName,
	patName,
	adminID
	from employee join
	(
		select pLastName || ', ' || pFirstName || ' ' || pMInit as patName,
		docID,
		adminID
		from patient join
		(
			select empID as docID, empAdministerID as adminID, patID
			from Orders join
			Administers using (orderID)
			where orderID = ?
		) o1 using (patID)
	) as p1 on (docID = empID)
) as e2 on (adminID = empID);

