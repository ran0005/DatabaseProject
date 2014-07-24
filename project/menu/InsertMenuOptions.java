package menu;

public interface InsertMenuOptions {
	//all the menu phrases
	public String insertMenu = "\n______Adding to Hospital______\n" +
				"Please choose an option\n" +
				"\t1. Add a New Patient\n" +
				"\t2. Add a New Worker\n" +
				"\t3. View Patient Options (Admitting, ordering Treatments, ect...)\n" +
				"\t4. View Hospital Options (Add Treatment, Room, ect...)\n" +
				"\t5. Back to Home\n" +
				"Input command: ";

	public  String insertPatientMenu = "\n______Adding a New Patient______\n" +
				"\t1. Add new Patient\n" +
				"\t2. Cancel Add\n" +
				"Input command: ";
	
	public  String insertWorkerMenu = "\n______Adding a New Worker______\n" +
					"\t1. Add new Employee\n" +
					"\t2. Add new Volunteer\n" +
					"\t3. Cancel add\n" +
					"Input command: ";

	public  String patientOptionMenu = "\n______Patient Options______\n" +
				"\t1. Admit Patient\n" +
				"\t2. Add Secondary Doctor(s)\n" +
				"\t3. Order Treatment\n" +
				"\t4. Adminster Treatment\n" +
				"\t5. Update Diagnosis\n" +
				"\t6. Checkout Patient\n" +
				"\t7. Back\n" +
				"Input command: ";

	public  String hospitalOptionMenu = "\n______Hospital Options______\n" +
				"\t1. Add New Diagnosis\n" +
				"\t2. Add New Treatment\n" +
				"\t3. Add New Room\n" +
				"\t4. Add New Service\n" +
				"\t5. Assign Staff to Service\n" +
				"\t6. Schedule Volunteer\n" +
				"\t7. Back\n" +
				"Input command: ";
}