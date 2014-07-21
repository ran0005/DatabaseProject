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
	String B4;
	String B5;
	String B6;
	String B7;
	String B8;
	String B9;
	String B10;
	//C
	*/
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
	String C8;
	//D
	String D1;
	String D2;
	String D3;
	String D4;
	String D5;
	String D6;
	String D7;*/
}
