package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import menu.Menu;

public class Comp5120 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Database db = new Database();
		db.connect();
		Menu m = new Menu(db);
		/*try {
			
			while (true) {
				System.out.println("\n______Hospital Database______");
				System.out.println("Please choose an option");
				System.out.println("\t1. Add to Hospital Database");
				System.out.println("\t2. View Database Statistics");
				System.out.println("\t3. Quit Database");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("1"))
					m.insertMenu();
				else if (command.equals("2"))
					m.viewMenu();
				else if (command.equals("3"))
					break;
				else
					System.out.println("Invalid command");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}
}
