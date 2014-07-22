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

	/*//A
	String A1;
	String A2;
	String A3;
	//B
	String B1;
	String B2;
	String B3;
	String B4;*/
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
	
	//String B8;
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
		+ "( select treatID, count(*) as occurences from (	select patID from Admit "
		+ "where patType = 'in'	) as r join ( select patID, treatID from Orders "
		+ ") as r1 using (patID) group by treatID ) as r3 using (treatID) "
		+ "order by occurences desc";
	/*
	String C6;
	String C7;
	String C8;*/
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
	
	//String D7;
}
