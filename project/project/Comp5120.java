package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Comp5120 {

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Database db = new Database();
		db.connect();
		String command = null;

		try {
			while (true) {
				System.out.println("type help for info");
				System.out.print("Input command: ");
				command = br.readLine().trim();
				if (command.equals("help")) {
					System.out.println("table:\t access tables");
					System.out.println("insert:\t insert into tables");
					System.out.println("display:\t shows all table names");
					System.out.println("commands:\t shows all insert keys");
				} else if (command.equals("table")) {
					System.out.print("Input choice table: ");
					String str = br.readLine();
					db.execute(str);
				} else if (command.equals("insert")) {
					System.out.print("Input statement: ");
					String st = br.readLine();
					db.add(st, br);
				} else if (command.equals("display")) {
					db.display();
				} else if (command.equals("commands")) {
					db.commands();
				} else if (command.equals("quit")) {
					break;
				} else {
					System.out.println("Invalid command type help for options");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}