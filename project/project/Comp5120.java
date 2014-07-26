package project;

import menu.Menu;

public class Comp5120 {

	public static void main(String[] args) {
		Database db = new Database();
		db.connect();
		new Menu(db);
	}
}
