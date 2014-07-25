package menu;

public interface ViewMenuOptions {
	// all the menu phrases
	public final String viewMenu = "\n______Hospital Information______\n"
			+ "Please choose an option\n"
			+ "\t1. View Tables\n"
			+ "\t2. View Room Information\n"
			+ "\t3. View Patient Information\n"
			+ "\t4. View Treatment and Diagnosis Information\n"
			+ "\t5. View Worker Information\n"
			+ "\t6. Back\n"
			+ "Input command: ";

	public  final String viewTableMenu = "\n______View Database Tables______\n"
			+ "\t1. View Employees\n"
			+ "\t2. View Volunteer\n"
			+ "\t3. View Services\n"
			+ "\t4. View Treatments\n"
			+ "\t5. View Patients\n"
			+ "\t6. View Diagnoses\n"
			+ "\t7. More Options\n" + "\t8. Back\n" + "Input command: ";

	public  final String viewMoreTablesMenu = "\n______View Database Tables Cont.______\n"
			+ "\t1. View Rooms\n"
			+ "\t2. View Admittance\n"
			+ "\t3. View Services Provided by Volunteers\n"
			+ "\t4. View Services Provided by Staff\n"
			+ "\t5. View Doctors Assigned\n"
			+ "\t6. View Treatment Orders\n"
			+ "\t7. View Administered Treatments\n"
			+ "\t8. Back\n"
			+ "Input command: ";

	public  final String viewRoomMenu = "\n______Room Information______\n"
			+ "Please choose an option\n"
			+ "\t1. HashMap Occupied Rooms\n"
			+ "\t2. HashMap Unoccupied Rooms\n"
			+ "\t3. HashMap All Rooms\n"
			+ "\t4. Back\n" + "Input command: ";

	public  final String viewPatientMenu = "\n______Patient Information______\n"
			+ "Please choose an option\n"
			+ "\t1. HashMap All Patients\n"
			+ "\t2. HashMap Current Admitted Patients\n"
			+ "\t3. HashMap All Patients Receiving Inpatient Services Between a Date Range\n"
			+ "\t4. HashMap All Discharged Patients Within a Date Range\n"
			+ "\t5. HashMap Current Outpatients\n"
			+ "\t6. More Options\n"
			+ "\t7. Back\n" + "Input command: ";

	public  final String viewMorePatientMenu = "\n______Patient Information Cont.______\n"
			+ "Please choose an option\n"
			+ "\t1. HashMap All Patients Receiving Outpatient Services Between a Date Range\n"
			+ "\t2. HashMap All Admissions for a Given Patient\n"
			+ "\t3. HashMap All Administered Treatments for a Given Patient\n"
			+ "\t4. HashMap All Patients That Were Admitted within 30 Days of Last Discharge\n"
			+ "\t5. View All Patient Adminttance Statistics\n"
			+ "\t6. Back\n"
			+ "Input command: ";

	public  final String viewTreatDiagMenu = "\n______Treatment and Diagnosis Information______\n"
			+ "\t1. HashMap Diagnoses Given to Inpatients\n"
			+ "\t2. HashMap Diagnoses Given to Outpatients\n"
			+ "\t3. HashMap Diagnoses Given to All Patients\n"
			+ "\t4. HashMap Treatments Performed on All Patients\n"
			+ "\t5. HashMap Treatments Performed on Inpatients\n"
			+ "\t6. HashMap Treatments Performed on Outpatients\n"
			+ "\t7. HashMap Diagnoses of Patients with the Highest Admissions\n"
			+ "\t8. HashMap all Employees involved with a Given Treatment\n"
			+ "\t9. Back\n" + "Input command: ";

	public  final String viewWorkerMenu = "\n______Worker Information______\n"
			+ "\t1. HashMap All Hospital Workers\n"
			+ "\t2. HashMap Volunteers that Work at the Information Desk on Tuesday\n"
			+ "\t3. HashMap Primary Doctors of Patients with 4 or more Admissions in a Year\n"
			+ "\t4. HashMap Diagnoses Given by a Given Doctor\n"
			+ "\t5. HashMap Treatments Given by a Given Doctor\n"
			+ "\t6. HashMap Treatments Participated in by a Given Doctor\n"
			+ "\t7. HashMap Employees Who Have Treated Every Inpatient\n"
			+ "\t8. Back\n" + "Input command: ";
}