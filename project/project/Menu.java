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
		boolean t = true;
		try {
			while (t) {
				System.out.println("\n______Adding to Hospital______");
				System.out.println("Please choose an option");
				System.out.println("\t1. Add a New Patient");
				System.out.println("\t2. Add a New Worker");
				System.out.println("\t3. View Patient Options (Admitting, ordering Treatments, ect.)");
				System.out.println("\t4. View Hospital Options (Add Treatment, Room, ect.)");
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
					t = false;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void  insertPatientMenu(){
		boolean t = true;
		
		try {
			while (t) {
				System.out.println("\n______Adding a New Patient______");
				System.out.println("\t1. Add new Patient");
				System.out.println("\t2. Cancel Add");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1")) 
					db.add("patient insert", br);
				else if (command.equals("2"))
					t = false;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertWorkerMenu(){
		boolean t = true;
		
		try {
			while (t) {
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
					t = false;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void patientOptionMenu(){
		boolean t = true;
		
		try {
			while (t) {
				System.out.println("\n______Patient Options______");
				System.out.println("\t1. Admit Patient");
				System.out.println("\t2. Add Secondary Doctor(s)");
				System.out.println("\t3. Order Treatment");
				System.out.println("\t4. Adminster Treatment");
				System.out.println("\t5. Update Diagnosis");
				System.out.println("\t6. Checkout Patient");
				System.out.println("\t7. Cancel");
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
					t = false;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void hospitalOptionMenu(){
	
	}
	
	public void viewMenu(){
	
	}
}
	
	public void hospitalOptionMenue(){
	
	}
	
	public void viewMenue(){
	
	}
}
