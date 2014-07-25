package project;

public interface Queries {

	String employee = "select * from employee";
	String volunteer = "select * from volunteer";
	String services = "select * from services";
	String treatment = "select * from treatment";
	String patient = "select * from patient";
	String diagnosis = "select * from diagnosis";
	String room = "select * from room";
	String admit = "select * from admit";
	String volprovide = "select * from volprovide";
	String staffprovide = "select * from staffprovide";
	String assigndoc = "select * from assigndoc";
	String orders = "select * from orders";
	String administers = "select * from administers";
	
	String employeeinsert = "insert into employee values" + "(?,?,?,?,?,?)";
	String volunteerinsert = "insert into volunteer values" + "(?,?,?,?,?)";
	String servicesinsert = "insert into services values" + "(?,?)";
	String treatmentinsert = "insert into treatment values" + "(?,?,?)";
	String patientinsert = "insert into patient values" + "(?,?,?,?,?,?)";
	String diagnosisinsert= "insert into diagnosis values" + "(?,?)";
	String roominsert = "insert into room values" + "(?,?,?)";
	String admitinsert = "insert into admit values" + "(?,?,?,?,?,?,?)";
	String volProvideinsert = "insert into volprovide values" + "(?,?,?)";
	String staffProvideinsert = "insert into staffprovide values" + "(?,?)";
	String assignDocinsert = "insert into assigndoc values" + "(?,?,?,?)";
	String ordersinsert = "insert into orders values" + "(?,?,?,?)";
	String administersinsert = "insert into administers values" + "(?,?,?,?,?,?)";

	///A
	String A1 = "select roomNum, pLastName || ', ' || pFirstName || ' ' || pMInit as Name, startTime "
			+ "from patient join "
			+ "( "
			+ "	select roomNum, patID, startTime "
			+ "	from admit join "
			+ "	( "
			+ "		select roomNum, patID "
			+ "		from Room "
			+ "		where patID IS NOT NULL "
			+ "	) as a1 using (patID) "
			+ "	where endTime IS NULL "
			+ ") as a2 using (patID) "
			+ "order by roomNum;";
			
	String A2 = "select roomNum "
			+ "from Room "
			+ "where patID IS NULL;";
			
	String A3 = "select roomNum, pLastName || ', ' || pFirstName || ' ' || pMInit as Name, startTime "
			+ "from room left join "
			+ "( "
			+ "	select patID, pFirstName, pMInit, pLastName, startTime "
			+ "	from patient join "
			+ "	( "
			+ "		select patID, startTime "
			+ "		from admit "
			+ "		where endTime IS NULL "
			+ "	) as p1 using (patID) "
			+ ") as p2 using (patID);";
	
	//B
	String B1 = "select distinct patID, pLastName || ', ' || pFirstName || ' ' || pMInit as Name, "
			+ "emergContact, insurance from Patient "
			+ "order by patID;";
	
	String B2 = "select distinct patID, pLastName || ', ' || pFirstName || ' ' || pMInit as Name "
			+ "from Patient join Admit using (patID) "
			+ "where patType = 'in' and endTime is null;";
	
	String B3 = "select distinct patID, pLastName || ', ' || pFirstName || ' ' || pMInit as Name "
			+ "from patient join Admit using (patID) "
			+ "where startTime::date >= ?::date and startTime::date <= ?::date "
			+ "and patType ='in' "
			+ "order by patID;";
	
	String B4 = "select distinct patID, pLastName || ', ' || pFirstName || ' ' || pMInit as Name"
			+ "from patient join Admit using (patID) "
			+ "where endTime::date >= ?::date and endTime::date <= ?::date "
			+ "order by patID;";
	
	String B5 = "select patid, plastname||','||pfirstname||' '||pminit as name from patient "
				+ "join admit using (patid) "
				+ "where pattype = 'out' and endtime is null;";
	
	String B6 = "select patid, plastname||','||pfirstname||' '||pminit as name from patient "
				+ "join admit using (patid) "
				+ "where pattype = 'out' and startTime::date between ? and ?;";
	
	String B7 = "select patid, starttime, endtime, dname "
				+ "from patient "
				+ "join admit using (patid) "
				+ "join diagnosis using (diagid) "
				+ "where patID = ?;";
	
	String B8 = "select plastname||','||pfirstname||' '||pminit as name, tname, starttime, orderTime from patient "
				+ "join admit using (patid) "
				+ "join orders using (patid) "
				+ "join treatment using (treatid) "
				+ "where patID = 8 "
				+ "order by starttime desc, orderTime asc;";
	
	String B9 = "select Admit.patID, pLastName || ', ' || pFirstName ||' '|| pMInit as pName, dName, "
			+ "eLastName || ', ' || eFirstName ||' '|| eMInit as eName "
			+ "from Admit join Patient using (patID) "
				+ "join Employee on Employee.empID = Admit.admitDocID "
				+ "join Diagnosis using (diagID) "
				+ "join "
			+ "( "
				+ "select r.patID, recent, min(recent::date - r1.endTime::date) as time "
				+ "from "
				+ "( "
					+ "select patID, max(startTime) as recent "
					+ "from admit "
					+ "group by patID "
				+ ") as r "
				+ "join "
				+ "( "
					+ "select patID, startTime, endTime "
					+ "from admit "
				+ ") as r1 "
				+ "using (patID) "
				+ "where r.recent != r1.startTime "
				+ "group by r.patID, recent "
			+ ") as r2 "
			+ "on (r2.patID = Admit.patID and r2.recent = Admit.startTime) "
			+ "where time < 30; ";
	
	//timeBetween is from VisitIntervals
	String B10 = "select patID, pLastName || ', ' || pFirstName || ' ' || pMInit as pName, "
			+ "totalVisits, avgDuration, min(timeBetween), avg(timeBetween), max(timeBetween) "
		+ "from "
		+ "( "
			+ "select patID, count(*) as totalVisits "
			+ "from Admit "
		+ "group by patID "
		+ ") "
		+ "as r1 "
		+ "left join "
		+ "( "
			+ "select patID, avg(endTime::timestamp - startTime::timestamp) as avgDuration "
			+ "from Admit "
			+ "where endTime is not null "
			+ "group by patID "
		+ ") "
		+ "as r2 "
		+ "using (patID) "
		+ "left join VisitIntervals using (patID) "
		+ "join Patient using (patID) "
		+ "group by patID, totalVisits, avgDuration, pLastName, pFirstName, pMInit "
		+ "order by patID;";
	//C
	String C1 = "select Diagnosis.diagID, dName, occurences from Diagnosis join "
		+ "( select diagID, count(*) as occurences from Admit where patType = 'in' "
		+ "group by diagID )as r using (diagID) order by occurences desc";
	
	String C2 = "select Diagnosis.diagID, dName, occurences from Diagnosis join "
		+ "( select diagID, count(*) as occurences from Admit where patType = 'out'"
		+ " group by diagID ) as r using (diagID) order by occurences desc";
	
	String C3 = "select Diagnosis.diagID, dName, occurences from Diagnosis join "
		+ "( select diagID, count(*) as occurences from Admit group by diagID "
		+ ") as r using (diagID) order by occurences desc";
		
	String C4 = "select Treatment.treatID, tName, occurences from Treatment join "
		+ "( select treatID, count(*) as occurences from Orders group by treatID "
		+ ") as r using (treatID) order by occurences desc";
		
	String C5 = "select Treatment.treatID, tName, occurences from Treatment join "
		+ "( select treatID, count(*) as occurences from ( select distinct patID from Admit "
		+ "where patType = 'in'	) as r join ( select patID, treatID from Orders "
		+ ") as r1 using (patID) group by treatID ) as r3 using (treatID) "
		+ "order by occurences desc;";
	
	String C6 = "select treatID, tname, count(tname) "
		+ "	from orders join (select patID, startTime, endTime "
		+ "		from admit "
		+ "		where pattype = 'out') outpatients using (patID) "
		+ "	join Treatment using (treatID)	 "
		+ "	join Administers using (orderID) "
		+ "	where orderTime::timestamp > startTime::timestamp and (endTime is null or orderTime::timestamp < endTime::timestamp) "
		+ "	group by treatID, tname "
		+ "	order by count(tname) desc;";
				
	String C7 = "select dName, count(dName) "
		+ "from diagnosis join "
		+ "( "
		+ "	select patID, diagID "
		+ "	from admit join "
		+ "	( "
		+ "		select patID, COUNT(patID) as admissions "
		+ "		from admit "
		+ "		group by patID "
		+ "		having count(patID) = (select MAX(admissions) from ( "
		+ "			select patID, COUNT(patID) as admissions "
		+ "			from admit "
		+ "			group by patID "
		+ "			) as a1) "
		+ "	) as a2 using (patID) "
		+ ") as d1 using (diagID) "
		+ "group by dName "
		+ "order by count(dName);";
		
	String C8 = "select docName, patName, "
		+ "eLastName || ', ' || eFirstName || ' ' || eMInit as empName "
		+ "from employee join "
		+ "( "
		+ "	select eLastName || ', ' || eFirstName || ' ' || eMInit as docName, "
		+ "	patName, "
		+ "	adminID "
		+ "	from employee join "
		+ "	( "
		+ "		select pLastName || ', ' || pFirstName || ' ' || pMInit as patName, "
		+ "		docID, "
		+ "		adminID "
		+ "		from patient join "
		+ "		( "
		+ "			select empID as docID, empAdministerID as adminID, patID "
		+ "			from Orders join "
		+ "			Administers using (orderID) "
		+ "			where orderID = ? "
		+ "		) o1 on using (patID) "
		+ "	) as p1 on (docID = empID) "
		+ ") as e2 on (adminID = empID);";
	//D
	String D1 = "select * "
				+ "from (select empID as ID, eLastName || ', ' || eFirstName || ' ' || eMInit as EmpName, eType as Type, eHiredate as DateOfHire "
				+ "from Employee "
				+ "union "
				+ "select volID as ID, vLastName || ', ' || vFirstName || ' ' || vMInit as EmpName, 'Volunteer' as Type, vHiredate as DateOfHire "
				+ "from Volunteer) workers "
				+ "order by EmpName;";
	
	String D2 = "select volID, vLastName || ', ' || vFirstName || ' ' || vMInit as Name "
				+ "from Volunteer join VolProvide using (volID) "
				+ "where servType = 'Info desk' "
				+ "and dayOfWeek = 'Tue';";
	
	String D3 = "select distinct eLastName || ', ' || eFirstName || ' ' || eMInit as docName,  "
				+ "	pLastName || ', ' || pFirstName || ' ' || pMInit as patName, myYear "
				+ "from Employee join Admit on (Employee.empID = Admit.admitDocID) join (select patID, extract(year from startTime::date) myYear "
				+ "from Admit "
				+ "group by patID, extract(year from startTime::date) "
				+ "having count(extract(year from startTime::date)) >= 4) freqPatient using (patID) join Patient using (patID) "
				+ "where freqPatient.myYear = extract(year from Admit.startTime::date);";
	
	String D4 = "select eLastName || ', ' || eFirstName || ' ' || eMInit as Name, dName, diagCount "
				+ "from Employee join (select admitDocID, diagID, count(diagID) diagCount "
				+ "from Admit "
				+ "where admitDocID = ? "
				+ "group by admitDocID, diagID) diagInfo on (diagInfo.admitDocID = Employee.empID) "
				+ "	join Diagnosis using (diagID) "
				+ "order by diagCount desc;";
	
	String D5 = "select eLastName || ', ' || eFirstName || ' ' || eMInit as Name, tName, treatCount "
				+ "from Employee join (select empID, treatID, count(treatID) treatCount "
				+ "from Orders "
				+ "where empID = ? "
				+ "group by empID, treatID) treatInfo using (empID) "
				+ "	join Treatment using (treatID) "
				+ "order by treatCount desc;";
	
	String D6 = "select eLastName || ', ' || eFirstName || ' ' || eMInit as Name, tName, treatCount "
				+ "from Employee join (select empAdministerID, treatID, count(treatID) treatCount "
				+ "from Administers "
				+ "where empAdministerID = ? "
				+ "group by empAdministerID, treatID) treatInfo on (treatInfo.empAdministerID = Employee.empID) "
				+ "	join Treatment using (treatID) "
				+ "order by treatCount desc;";
	
	String D7 = "select empID, eLastName || ', ' || eFirstName || ' ' || eMInit as Name "
				+ "from (select empID "
				+ "from Employee "
				+ "except "
				+ "select distinct empID "
				+ "from (select empID, patID "
				+ "	from Employee, Patient "
				+ "	except "
				+ "	select * from EmployeePatientInteraction) NoInteraction) AllInteraction "
				+ "join Employee using (empID);";
}
