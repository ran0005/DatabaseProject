package menu;

import project.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

interface Command {
	void runCommand();
}

public class Menu implements ViewMenuOptions, InsertMenuOptions {

	private Database db;
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	private final String initMenuMessage = "\n______Hospital Database______\n" +
				"Please choose an option\n" +
				"\t1. Add to Hospital Database\n" +
				"\t2. View Database Statistics\n" +
				"\t3. Quit Database\n" +
				"Input command: ";

	//these are the main menus insert and view
	private final HashMap<Integer, Command> menus = new HashMap<Integer,Command>() 
	{
		{
			put(1, new Command() { public void runCommand() { menu(insertMenu, insertHashMap); }; });
			put(2, new Command() { public void runCommand() { menu(viewMenu, viewHashMap); }; });
		}
	};

	private final HashMap<Integer,Command> insertHashMap = new HashMap<Integer,Command>()
	{
		{
			put(1, new Command() { public void runCommand() { menu(insertPatientMenu,insertPatientHashMap); }; });
			put(2, new Command() { public void runCommand() { menu(insertWorkerMenu, insertWorkerHashMap); }; });
			put(3, new Command() { public void runCommand() { menu(patientOptionMenu, patientOptionsHashMap); }; });
			put(4, new Command() { public void runCommand() { menu(hospitalOptionMenu, hospitalOptionsHashMap); }; });
		}
	};	

	private final HashMap<Integer,Command> viewHashMap = new HashMap<Integer, Command>()
	{ 
		{
			put(1, new Command() { public void runCommand() { menu(viewTableMenu, viewTableHashMap); }; });
			put(2, new Command() { public void runCommand() { menu(viewRoomMenu, viewRoomHashMap); }; });
			put(3, new Command() { public void runCommand() { menu(viewPatientMenu, viewPatientHashMap); }; });
			put(4, new Command() { public void runCommand() { menu(viewTreatDiagMenu, viewTreatDiagHashMap); }; });
			put(5, new Command() { public void runCommand() { menu(viewWorkerMenu, viewWorkerHashMap); }; });
		}
	};

	// These are the HashMaps for view menus because reasons!
	public final HashMap<Integer, Command> viewMoreTablesHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("room"); }; });
			put(2, new Command() { public void runCommand() { db.execute("admit"); }; });
			put(3, new Command() { public void runCommand() { db.execute("volProvide"); }; });
			put(4, new Command() { public void runCommand() { db.execute("staffProvide"); }; });
			put(5, new Command() { public void runCommand() { db.execute("assignDoc"); }; });
			put(6, new Command() { public void runCommand() { db.execute("orders"); }; });
			put(7, new Command() { public void runCommand() { db.execute("administers"); }; });
		}
	};

	public final HashMap<Integer, Command> viewTableHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("employee"); }; });
			put(2, new Command() { public void runCommand() { db.execute("volunteer"); }; });
			put(3, new Command() { public void runCommand() { db.execute("services"); }; });
			put(4, new Command() { public void runCommand() { db.execute("treatment"); }; });
			put(5, new Command() { public void runCommand() { db.execute("patient"); }; });
			put(6, new Command() { public void runCommand() { db.execute("diagnosis"); }; });
			put(7, new Command() { public void runCommand() { menu(viewMoreTablesMenu, viewMoreTablesHashMap); }; });
		}
	};

	public final HashMap<Integer, Command> viewRoomHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("A1"); }; });
			put(2, new Command() { public void runCommand() { db.execute("A2"); }; });
			put(3, new Command() { public void runCommand() { db.execute("A3"); }; });
		}
	};

	public final HashMap<Integer, Command> viewMorePatientHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("B6"); }; });
			put(2, new Command() { public void runCommand() { db.execute("B7"); }; });
			put(3, new Command() { public void runCommand() { db.execute("B8"); }; });
			put(4, new Command() { public void runCommand() { db.execute("B9"); }; });
			put(5, new Command() { public void runCommand() { db.execute("B10"); }; });
		}
	};

	public final HashMap<Integer, Command> viewPatientHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("B1"); }; });
			put(2, new Command() { public void runCommand() { db.execute("B2"); }; });
			put(3, new Command() { public void runCommand() { db.execute("B3"); }; });
			put(4, new Command() { public void runCommand() { db.execute("B4"); }; });
			put(5, new Command() { public void runCommand() { db.execute("B5"); }; });
			put(6, new Command() { public void runCommand() { menu(viewMorePatientMenu, viewMorePatientHashMap); }; });
		}
	};

	public final HashMap<Integer, Command> viewTreatDiagHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("C1"); }; });
			put(2, new Command() { public void runCommand() { db.execute("C2"); }; });
			put(3, new Command() { public void runCommand() { db.execute("C3"); }; });
			put(4, new Command() { public void runCommand() { db.execute("C4"); }; });
			put(5, new Command() { public void runCommand() { db.execute("C5"); }; });
			put(6, new Command() { public void runCommand() { db.execute("C6"); }; });
			put(7, new Command() { public void runCommand() { db.execute("C7"); }; });
			put(8, new Command() { public void runCommand() { db.execute("C8"); }; });
		}	
	};

	public final HashMap<Integer, Command> viewWorkerHashMap = new HashMap<Integer, Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.execute("D1"); }; });
			put(2, new Command() { public void runCommand() { db.execute("D2"); }; });
			put(3, new Command() { public void runCommand() { db.execute("D3"); }; });
			put(4, new Command() { public void runCommand() { db.execute("D4"); }; });
			put(5, new Command() { public void runCommand() { db.execute("D5"); }; });
			put(6, new Command() { public void runCommand() { db.execute("D6"); }; });
			put(7, new Command() { public void runCommand() { db.execute("D7"); }; });
		}
	};

	//These are the HashMaps for insert menus because reasons!
	public final HashMap<Integer,Command> insertPatientHashMap = new HashMap<Integer,Command>()
	{
		{
			put(1,new Command() { public void runCommand() { db.add("patient insert", br); }; });
		}
	};

	public final HashMap<Integer,Command> insertWorkerHashMap = new HashMap<Integer,Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.add("employee insert", br); }; });
			put(2, new Command() { public void runCommand() { db.add("volunteer insert", br); }; });
		}							
	};

	public final HashMap<Integer,Command> patientOptionsHashMap = new HashMap<Integer,Command>()
	{
		{
			put(1, new Command() { public void runCommand() { db.add("admit insert","\n______Admitting Patient______" , br); }; });
			put(2, new Command() { public void runCommand() { db.add("assignDoc insert","\n______Adding Secondary Doctor______", br); }; });
			put(3, new Command() { public void runCommand() { db.add("orders insert","\n______Order Treatment______", br); }; });
			put(4, new Command() { public void runCommand() { db.add("administer insert","\n______Administer Treatment______", br); }; });
			//put(5, System.out.println("\n______Update Patient Diagnosis______"); /*TODO add update to admit*/ });
			//put(6, System.out.println("\n______Checkout Patient______"); /*TODO add update to admit*/ });
		}						
	};

	public final HashMap<Integer,Command> hospitalOptionsHashMap = new HashMap<Integer,Command>()
	{
		{
			put(1,  new Command() { public void runCommand() { db.add("diagnosis insert","\n______Add Diagnosis______", br); }; });
			put(2,  new Command() { public void runCommand() { db.add("treatment insert","\n______Add Treatment______", br); }; });
			put(3,  new Command() { public void runCommand() { db.add("room insert","\n______Add Room______", br); }; });
			put(4,  new Command() { public void runCommand() { db.add("services insert","\n______Add Service______", br); }; });
			put(5,  new Command() { public void runCommand() { db.add("staffprovide insert","\n______Assign Staff______", br); }; });
			put(6,  new Command() { public void runCommand() { db.add("volprovide insert","\n______Schedule Volunteer______", br); }; });		
		}
	};

	public Menu(Database db) {
		this.db = db;
		menu(initMenuMessage, menus);
	}

	public void menu(String message, HashMap<Integer,Command> hm) {
		while (true) {
			try {
				System.out.print(message);
				int command = Integer.parseInt(br.readLine());
				if (command > hm.size() + 1) {
					hm.get(command).runCommand();
				} else if (command == hm.size() + 1) {
					break;
				} else {
					System.out.println("Invalid command received");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
