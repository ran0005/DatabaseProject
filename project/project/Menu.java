package project;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {

	private Database db;
	private String command = null;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public Menu(Database db){
		this.db = db;
	}
	
	public void insertMenu(){
		try {
			while (true) {
				System.out.println("\n______Adding to Hospital______");
				System.out.println("Please choose an option");
				System.out.println("\t1. Add a New Patient");
				System.out.println("\t2. Add a New Worker");
				System.out.println("\t3. View Patient Options (Admitting, ordering Treatments, ect...)");
				System.out.println("\t4. View Hospital Options (Add Treatment, Room, ect...)");
				System.out.println("\t5. Back to Home");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					insertPatientMenu();
				else if (command.equals("2"))
					insertWorkerMenu();
				else if (command.equals("3"))
					patientOptionMenu();
				else if (command.equals("4"))
					hospitalOptionMenu();
				else if (command.equals("5"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void  insertPatientMenu(){
		
		try {
			while (true) {
				System.out.println("\n______Adding a New Patient______");
				System.out.println("\t1. Add new Patient");
				System.out.println("\t2. Cancel Add");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1")) 
					db.add("patient insert", br);
				else if (command.equals("2"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWorkerMenu(){

		try {
			while (true) {
				System.out.println("\n______Adding a New Worker______");
				System.out.println("\t1. Add new Employee");
				System.out.println("\t2. Add new Volunteer");
				System.out.println("\t3. Cancel add");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					db.add("employee insert", br);
				else if (command.equals("2")) 
					db.add("volunteer insert", br);
				else if (command.equals("3"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void patientOptionMenu(){
		
		try {
			while (true) {
				System.out.println("\n______Patient Options______");
				System.out.println("\t1. Admit Patient");
				System.out.println("\t2. Add Secondary Doctor(s)");
				System.out.println("\t3. Order Treatment");
				System.out.println("\t4. Adminster Treatment");
				System.out.println("\t5. Update Diagnosis");
				System.out.println("\t6. Checkout Patient");
				System.out.println("\t7. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1")){
					System.out.println("\n______Admitting Patient______");
					db.add("admit insert", br);
				}
				else if (command.equals("2")) {
					System.out.println("\n______Adding Secondary Doctor______");
					db.add("assignDoc insert", br);
				}
				else if (command.equals("3")){
					System.out.println("\n______Order Treatment______");
					db.add("orders insert", br);
				}
				else if (command.equals("4")){
					System.out.println("\n______Administer Treatment______");
					db.add("administer insert", br);
				}
				else if (command.equals("5")){
					System.out.println("\n______Update Patient Diagnosis______");
					//TODO add update to admit
				}
				else if (command.equals("6")){
					System.out.println("\n______Checkout Patient______");
					//TODO add update to admit
				}	
				else if (command.equals("7"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void hospitalOptionMenu(){
		
		try {
			while (true) {
				System.out.println("\n______Hospital Options______");
				System.out.println("\t1. Add New Diagnosis");
				System.out.println("\t2. Add New Treatment");
				System.out.println("\t3. Add New Room");
				System.out.println("\t4. Add New Service");
				System.out.println("\t5. Assign Staff to Service");
				System.out.println("\t6. Schedule Volunteer");
				System.out.println("\t7. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1")){
					System.out.println("\n______Add Diagnosis______");
					db.add("diagnosis insert", br);
				}
				else if (command.equals("2")) {
					System.out.println("\n______Add Treatment______");
					db.add("treatment insert", br);
				}
				else if (command.equals("3")){
					System.out.println("\n______Add Room______");
					db.add("room insert", br);
				}
				else if (command.equals("4")){
					System.out.println("\n______Add Service______");
					db.add("services insert", br);
				}
				else if (command.equals("5")){
					System.out.println("\n______Assign Staff______");
					db.add("staffprovide insert", br);
				}
				else if (command.equals("6")){
					System.out.println("\n______Schedule Volunteer______");
					db.add("volprovide insert", br);
				}	
				else if (command.equals("7"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void viewMenu(){
		try {
			while (true) {
				System.out.println("\n______Hospital Information______");
				System.out.println("Please choose an option");
				System.out.println("\t1. View Tables");
				System.out.println("\t2. View Room Information");
				System.out.println("\t3. View Patient Information");
				System.out.println("\t4. View Treatment and Diagnosis Information");
				System.out.println("\t5. View Worker Information");
				System.out.println("\t6. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					viewTableMenu();
				else if (command.equals("2"))
					viewRoomMenu();
				else if (command.equals("3"))
					viewPatientMenu();
				else if (command.equals("4"))
					viewTreatDiagMenu();
				else if (command.equals("5"))
					viewWorkerMenu();
				else if (command.equals("6"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewTableMenu(){
		
		try {
			while (true) {
				System.out.println("\n______View Database Tables______");
				System.out.println("\t1. View Employees");
				System.out.println("\t2. View Volunteer");
				System.out.println("\t3. View Services");
				System.out.println("\t4. View Treatments");
				System.out.println("\t5. View Patients");
				System.out.println("\t6. View Diagnoses");
				System.out.println("\t7. More Options");
				System.out.println("\t8. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					db.execute("employee");
				else if (command.equals("2")) 
					db.execute("volunteer");
				else if (command.equals("3"))
					db.execute("services");
				else if (command.equals("4"))
					db.execute("treatment");
				else if (command.equals("5"))
					db.execute("patient");
				else if (command.equals("6"))
					db.execute("diagnosis");
				else if (command.equals("7"))
					viewMoreTablesMenu();
				else if (command.equals("8"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewMoreTablesMenu(){
		
		try {
			while (true) {
				System.out.println("\n______View Database Tables Cont.______");
				System.out.println("\t1. View Rooms");
				System.out.println("\t2. View Admittance");
				System.out.println("\t3. View Services Provided by Volunteers");
				System.out.println("\t4. View Services Provided by Staff");
				System.out.println("\t5. View Doctors Assigned");
				System.out.println("\t6. View Treatment Orders");
				System.out.println("\t7. View Administered Treatments");
				System.out.println("\t8. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					db.execute("room");
				else if (command.equals("2")) 
					db.execute("admit");
				else if (command.equals("3"))
					db.execute("volProvide");
				else if (command.equals("4"))
					db.execute("staffProvide");
				else if (command.equals("5"))
					db.execute("assignDoc");
				else if (command.equals("6"))
					db.execute("orders");
				else if (command.equals("7"))
					db.execute("administers");
				else if (command.equals("8"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewRoomMenu(){
		
		try {
			while (true) {
				System.out.println("\n______Room Information______");
				System.out.println("Please choose an option");
				System.out.println("\t1. List Occupied Rooms");
				System.out.println("\t2. List Unoccupied Rooms");
				System.out.println("\t3. List All Rooms");
				System.out.println("\t4. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1")){
					//db.execute("A1");
					}
				else if (command.equals("2")){
					//db.execute("A2");
					}
				else if (command.equals("3")){
					//db.execute("A3");
					}
				else if (command.equals("4"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewPatientMenu(){
	
		try {
			while (true) {
				System.out.println("\n______Patient Information______");
				System.out.println("Please choose an option");
				System.out.println("\t1. List All Patients");
				System.out.println("\t2. List Current Admitted Patients");
				System.out.println("\t3. List All Patients Receiving Inpatient Services Between a Date Range");
				System.out.println("\t4. List All Discharged Patients Within a Date Range");
				System.out.println("\t5. List Current Outpatients");
				System.out.println("\t6. More Options");
				System.out.println("\t7. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1")){
					//db.execute("B1");
					}
				else if (command.equals("2")){
					//db.execute("B2");
					}
				else if (command.equals("3")){
					//db.execute("B3");
					}
				else if (command.equals("4")){
					//db.execute("B4");
					}
				else if (command.equals("5"))
					db.execute("B5");
				else if (command.equals("6"))
					viewMorePatientMenu();
				else if (command.equals("7"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewMorePatientMenu(){
	
		try {
			while (true) {
				System.out.println("\n______Patient Information Cont.______");
				System.out.println("Please choose an option");
				System.out.println("\t1. List All Patients Receiving Outpatient Services Between a Date Range");
				System.out.println("\t2. List All Admissions for a Given Patient");
				System.out.println("\t3. List All Administered Treatments for a Given Patient");
				System.out.println("\t4. List All Patients That Were Admitted within 30 Days of Last Discharge");
				System.out.println("\t5. View All Patient Adminttance Statistics");
				System.out.println("\t6. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					db.execute("B6");
				else if (command.equals("2"))
					db.execute("B7");
				else if (command.equals("3")){
					//db.execute("B8");
					}
				else if (command.equals("4"))
					db.execute("B9");
				else if (command.equals("5"))
					db.execute("B10");
				else if (command.equals("6"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	public void viewTreatDiagMenu(){
		
		try {
			while (true) {
				System.out.println("\n______Treatment and Diagnosis Information______");
				System.out.println("\t1. List Diagnoses Given to Inpatients");
				System.out.println("\t2. List Diagnoses Given to Outpatients");
				System.out.println("\t3. List Diagnoses Given to All Patients");
				System.out.println("\t4. List Treatments Performed on All Patients");
				System.out.println("\t5. List Treatments Performed on Inpatients");
				System.out.println("\t6. List Treatments Performed on Outpatients");
				System.out.println("\t7. List Diagnoses of Patients with the Highest Admissions");
				System.out.println("\t8. List all Employees involved with a Given Treatment");
				System.out.println("\t9. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					db.execute("C1");
				else if (command.equals("2")) 
					db.execute("C2");
				else if (command.equals("3"))
					db.execute("C3");
				else if (command.equals("4"))
					db.execute("C4");
				else if (command.equals("5"))
					db.execute("C5");
				else if (command.equals("6")){
					//db.execute("C6");
					}
				else if (command.equals("7")){
					//db.execute("C7");
					}
				else if (command.equals("8")){
					//db.execute("C8");
					}
				else if (command.equals("9"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void viewWorkerMenu(){
		
		try {
			while (true) {
				System.out.println("\n______Worker Information______");
				System.out.println("\t1. List All Hospital Workers");
				System.out.println("\t2. List Volunteers that Work at the Information Desk on Tuesday");
				System.out.println("\t3. List Primary Doctors of Patients with 4 or more Admissions in a Year");
				System.out.println("\t4. List Diagnoses Given by a Given Doctor");
				System.out.println("\t5. List Treatments Given by a Given Doctor");
				System.out.println("\t6. List Treatments Participated in by a Given Doctor");
				System.out.println("\t7. List Employees Who Have Treated Every Inpatient");
				System.out.println("\t8. Back");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					db.execute("D1");
				else if (command.equals("2"))
					db.execute("D2");
				else if (command.equals("3"))
					db.execute("D3");
				else if (command.equals("4"))
					db.execute("D4");
				else if (command.equals("5"))
					db.execute("D5");
				else if (command.equals("6"))
					db.execute("D6");
				else if (command.equals("7")){
					//db.execute("D7");
					}
				else if (command.equals("8"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
